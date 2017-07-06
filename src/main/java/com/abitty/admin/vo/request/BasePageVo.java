package com.abitty.admin.vo.request;

/**
 * Created by yak on 17/6/12.
 */
public class BasePageVo {
    public final static int PAGE_SHOW_COUNT = 50;
    protected int pageNum = 1;
    protected int pageSize = 0;
    protected int totalCount = 0;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize > 0 ? pageSize : PAGE_SHOW_COUNT;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getStartIndex() {
        int pageNum = this.getPageNum() > 0 ? this.getPageNum() - 1 : 0;
        return pageNum * this.getPageSize();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BasePageVo{");
        sb.append("pageNum=").append(pageNum);
        sb.append(", pageSize=").append(pageSize);
        sb.append(", totalCount=").append(totalCount);
        sb.append('}');
        return sb.toString();
    }
}
