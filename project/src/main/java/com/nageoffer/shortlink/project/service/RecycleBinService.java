package com.nageoffer.shortlink.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nageoffer.shortlink.project.dao.entity.ShortLinkDO;
import com.nageoffer.shortlink.project.dto.req.*;
import com.nageoffer.shortlink.project.dto.resp.ShortLinkPageRespDTO;

/**
 * ClassName:RecycleBinService
 * Description:
 * 回收站管理接口层
 * @Author DubPAN
 * @Create2024/6/5 16:14
 * @Version 1.0
 */
public interface RecycleBinService extends IService <ShortLinkDO> {
    /**
     * 保存回收站
     * @param requestParam 请求参数
     */
    void saveRecycleBin(RecycleBinSaveReqDTO requestParam);

    /**
     * 分页查询回收站里的短链接
     * @param requestParam 分页查询短链接请求参数
     * @return 短链接分页返回结果
     */
    IPage<ShortLinkPageRespDTO> pageShortLink(ShortLinkRecycleBinPageReqDTO requestParam);

    /**
     * 恢复短链接
     * @param requestParam 恢复短链接请求参数
     */
    void recoverRecycleBin(RecycleBinRecoverReqDTO requestParam);

    /**
     * 移除短链接
     * @param requestParam 移除短链接请求参数
     */
    void removeRecycleBin(RecycleBinRemoveReqDTO requestParam);
}
