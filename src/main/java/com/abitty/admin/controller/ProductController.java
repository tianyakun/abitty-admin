package com.abitty.admin.controller;

import com.abitty.admin.cache.CatalogCache;
import com.abitty.admin.vo.ProductVo;
import com.abitty.admin.vo.request.ProductSearchVo;
import com.abitty.admin.entity.TblCatalog;
import com.abitty.admin.entity.TblProduct;
import com.abitty.admin.service.ProductService;
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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by yak on 17/6/12.
 */
@Controller
@RequestMapping(value = "/product")
public class ProductController {

    private final static Logger logger = LoggerFactory.getLogger(ProductController.class);

    private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private ProductService productService;

    @Autowired
    private CatalogCache catalogCache;

    @RequestMapping(value = "/list")
    public ModelAndView productList(ProductSearchVo vo, Model model) {
        logger.info("获取商品列表请求 {}", vo);

        Map<String, Object> paramMap = getQueryParamMap(vo);

        List<TblProduct> tblProductList = productService.pageQuery(paramMap);

        List<ProductVo> productList = buildProductVoList(tblProductList);

        int totalCount = productService.count(paramMap);

        logger.info("获取商品类别列表查询返回: productList={}, totalCount={}", productList, totalCount);

        model.addAttribute("productList", productList);

        model.addAttribute("totalCount", totalCount);
        model.addAttribute("pageSize", vo.getPageSize());

        model.addAttribute("productNo", vo.getProductNo());
        model.addAttribute("productName", vo.getProductName());
        model.addAttribute("catalogNo", vo.getCatalogNo());
        model.addAttribute("status", vo.getStatus());
        model.addAttribute("catalogList", catalogCache.getCatalogList());

        return new ModelAndView("product/list");
    }

    @RequestMapping(value = "/view/{id}")
    public ModelAndView productView(@PathVariable("id") final String id, Model model) {
        logger.info("获取商品详情请求 id = {}", id);

        TblProduct tblProduct = productService.getByPrimaryKey(Ints.tryParse(id));

        ProductVo productVo = buildProductVo(tblProduct);

        logger.info("获取商品详情请求返回: product={}", productVo);

        model.addAttribute("product", productVo);

        return new ModelAndView("product/view");
    }

    @RequestMapping(value = "/edit/{id}")
    public ModelAndView productEditView(@PathVariable("id") final String id, Model model) {
        logger.info("获取商品详情请求 id = {}", id);

        TblProduct tblProduct = productService.getByPrimaryKey(Ints.tryParse(id));

        ProductVo productVo = buildProductVo(tblProduct);

        logger.info("获取商品详情请求返回: product={}", productVo);

        model.addAttribute("product", productVo);
        model.addAttribute("catalogList", catalogCache.getCatalogList());

        return new ModelAndView("product/edit");
    }

    @RequestMapping(value = "/update")
    public ModelAndView productUpdate(TblProduct product,  Model model) {
        logger.info("修改商品请求 product = {}", product);

        if (product != null) {
            productService.updateProduct(product);

        }

        TblProduct tblProduct = productService.getByPrimaryKey(product.getId());

        ProductVo productVo = buildProductVo(tblProduct);

        logger.info("获取商品详情请求返回: product={}", productVo);

        model.addAttribute("product", productVo);

        return new ModelAndView("product/view");
    }

    @RequestMapping(value = "/add")
    public ModelAndView productAddView(Model model) {

        model.addAttribute("catalogList", catalogCache.getCatalogList());

        return new ModelAndView("product/add");
    }

    @RequestMapping(value = "/save")
    public ModelAndView productSave(TblProduct tblProduct, Model model) {
        logger.info("新增商品 {}", tblProduct);

        tblProduct.setCreateTime(new Date());

        productService.add(tblProduct);

        TblProduct dbProduct = productService.getByPrimaryKey(tblProduct.getId());

        ProductVo productVo = buildProductVo(dbProduct);

        logger.info("新增商品返回: product={}", productVo);

        model.addAttribute("product", productVo);

        return new ModelAndView("product/view");
    }

    private Map<String, Object> getQueryParamMap(ProductSearchVo vo) {
        Map<String, Object> paramMap = Maps.newHashMap();
        if (!Strings.isNullOrEmpty(vo.getProductNo())) {
            paramMap.put("productNo", vo.getProductNo());
        }
        if (!Strings.isNullOrEmpty(vo.getProductName())) {
            paramMap.put("productName", vo.getProductName());
        }
        if (!Strings.isNullOrEmpty(vo.getCatalogNo())) {
            paramMap.put("catalogNo", vo.getCatalogNo());
        }
        if (!Strings.isNullOrEmpty(vo.getStatus()) && Ints.tryParse(vo.getStatus()) != null) {
            paramMap.put("status", Ints.tryParse(vo.getStatus()));
        }

        paramMap.put("offset", vo.getStartIndex());
        paramMap.put("limit", vo.getPageSize());
        return paramMap;
    }

    private List<ProductVo> buildProductVoList(List<TblProduct> tblProductList) {
        if (CollectionUtils.isEmpty(tblProductList)) {
            return Lists.newArrayList();
        }

        return Lists.transform(tblProductList, new Function<TblProduct, ProductVo>() {
            @Override
            public ProductVo apply(TblProduct input) {
                return buildProductVo(input);
            }
        });

    }

    private ProductVo buildProductVo(TblProduct input) {
        if (input == null) {
            return null;
        }

        ProductVo productVo = new ProductVo();
        productVo.setId(input.getId());
        productVo.setProductNo(input.getProductNo());
        productVo.setProductName(input.getProductName());
        productVo.setCatalogNo(input.getCatalogNo());
        productVo.setDescription(input.getDescription());
        productVo.setPrice(input.getPrice());
        productVo.setNowPrice(input.getNowPrice());
        productVo.setStatus(input.getStatus());
        productVo.setIcon(input.getIcon());
        productVo.setDetail(input.getDetail());
        productVo.setImages(input.getImages());
        productVo.setDeliveryType(input.getDeliveryType());
        if (input.getCreateTime() != null) {
            productVo.setCreateTime(DATE_FORMAT.format(input.getCreateTime()));
        }
        TblCatalog catalog = catalogCache.getCatalog(input.getCatalogNo());
        if (catalog != null) {
            productVo.setCatalogName(catalog.getCatalogName());
        }

        return productVo;
    }



}
