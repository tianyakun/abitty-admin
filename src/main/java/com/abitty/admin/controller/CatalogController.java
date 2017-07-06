package com.abitty.admin.controller;

import com.abitty.admin.cache.CatalogCache;
import com.abitty.admin.constant.AbittyConstants;
import com.abitty.admin.entity.TblCatalog;
import com.abitty.admin.service.CatalogService;
import com.abitty.admin.vo.CatalogVo;
import com.abitty.admin.vo.request.CatalogSearchVo;
import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.primitives.Ints;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by yak on 17/6/12.
 */
@Controller
@RequestMapping(value = "/catalog")
public class CatalogController {

    private final static Logger logger = LoggerFactory.getLogger(CatalogController.class);

    @Autowired
    private CatalogService catalogService;

    @Autowired
    private CatalogCache catalogCache;

    @RequestMapping(value = "/list")
    public ModelAndView getCatalogList(CatalogSearchVo vo, Model model) {
        logger.info("获取商品类别列表请求 {}", vo);

        Map<String, Object> paramMap = getQueryParamMap(vo);

        List<TblCatalog> tblCatalogList = catalogService.pageQuery(paramMap);

        List<CatalogVo> catalogVoList = buildCatalogVoList(tblCatalogList);

        long totalCount = catalogService.count(paramMap);

        logger.info("获取商品类别列表查询返回: catalogVoList={}, totalCount={}", catalogVoList, totalCount);

        model.addAttribute("catalogList", catalogVoList);

        model.addAttribute("totalCount", totalCount);
        model.addAttribute("pageSize", vo.getPageSize());

        model.addAttribute("catalogNo", vo.getCatalogNo());
        model.addAttribute("catalogName", vo.getCatalogName());
        model.addAttribute("isDelete", vo.getIsDelete());

        return new ModelAndView("catalog/list");
    }

    @RequestMapping(value = "/edit/{id}")
    public ModelAndView productEditView(@PathVariable("id") final String id, Model model) {
        logger.info("获取品类详情请求 id = {}", id);

        TblCatalog tblCatalog = catalogService.getByPrimaryKey(Ints.tryParse(id));

        CatalogVo catalogVo = buildCatalogVo(tblCatalog);

        logger.info("获取品类详情返回: catalogVo={}", catalogVo);

        model.addAttribute("catalog", catalogVo);

        return new ModelAndView("catalog/edit");
    }

    @RequestMapping(value = "/update")
    public ModelAndView productUpdate(TblCatalog tblCatalog,  Model model) {
        logger.info("修改品类请求 tblCatalog = {}", tblCatalog);

        if (tblCatalog != null) {
            catalogService.update(tblCatalog);

            catalogCache.init();
        }

        return new ModelAndView("redirect:/catalog/list");
    }

    @RequestMapping(value = "/add")
    public ModelAndView productAddView(Model model) {

        return new ModelAndView("catalog/add");
    }

    @RequestMapping(value = "/save")
    public ModelAndView productSave(TblCatalog tblCatalog, Model model) {
        logger.info("新增品类 {}", tblCatalog);

        tblCatalog.setCreateTime(new Date());

        catalogService.add(tblCatalog);

        catalogCache.init();

        return new ModelAndView("redirect:/catalog/list");
    }

    private Map<String, Object> getQueryParamMap(CatalogSearchVo vo) {
        Map<String, Object> paramMap = Maps.newHashMap();
        if (!Strings.isNullOrEmpty(vo.getCatalogNo())) {
            paramMap.put("catalogNo", vo.getCatalogNo());
        }
        if (!Strings.isNullOrEmpty(vo.getCatalogName())) {
            paramMap.put("catalogName", vo.getCatalogName());
        }
        if (!Strings.isNullOrEmpty(vo.getIsDelete()) && Ints.tryParse(vo.getIsDelete()) != null) {
            paramMap.put("isDelete", Ints.tryParse(vo.getIsDelete()));
        }

        paramMap.put("offset", vo.getStartIndex());
        paramMap.put("limit", vo.getPageSize());
        return paramMap;
    }

    private List<CatalogVo> buildCatalogVoList(List<TblCatalog> tblCatalogList) {
        if (CollectionUtils.isEmpty(tblCatalogList)) {
            return Lists.newArrayList();
        }

        return Lists.transform(tblCatalogList, new Function<TblCatalog, CatalogVo>() {
            @Override
            public CatalogVo apply(TblCatalog input) {
                return buildCatalogVo(input);
            }
        });
    }

    private CatalogVo buildCatalogVo(TblCatalog input) {
        if (input == null) {
            return null;
        }

        CatalogVo catalogVo = new CatalogVo();
        catalogVo.setId(input.getId());
        catalogVo.setCatalogNo(input.getCatalogNo());
        catalogVo.setCatalogName(input.getCatalogName());
        catalogVo.setIcon(input.getIcon());
        catalogVo.setPid(input.getPid());
        catalogVo.setDescription(input.getDescription());
        catalogVo.setDeliveryType(input.getDeliveryType());
        catalogVo.setIsDelete(input.getIsDelete());
        if (input.getCreateTime() == null) {
            catalogVo.setCreateTime("");
        } else {
            catalogVo.setCreateTime(AbittyConstants.DATETIME_FORMAT.format(input.getCreateTime()));
        }
        return catalogVo;
    }


}
