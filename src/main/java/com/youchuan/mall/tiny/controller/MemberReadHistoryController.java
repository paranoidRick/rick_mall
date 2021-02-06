package com.youchuan.mall.tiny.controller;

import com.youchuan.mall.tiny.common.api.CommonResult;
import com.youchuan.mall.tiny.nosql.mongodb.document.MemberReadHistory;
import com.youchuan.mall.tiny.service.MemberReadHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api(tags = "MemberReadHistoryController", description = "会员商品浏览记录管理")
@RequestMapping("/member/readHistory")
public class MemberReadHistoryController {

    // delete 和 create 都是POST
    // list 是get，因为只需要查就行了
    @Autowired
    private MemberReadHistoryService memberReadHistoryService;
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ApiOperation("创建浏览记录")
    @ResponseBody   // @ResponseBody的作用其实是将java对象转为json格式的数据
    public CommonResult create(@RequestBody MemberReadHistory memberReadHistory) { //@RequestBody主要用来接收前端传递给后端的json字符串中的数据的(请求体中的数据的)
        int count = memberReadHistoryService.create(memberReadHistory);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ApiOperation("删除浏览记录")
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<String> ids) { // @RequestParam指定前端发送过来的请求参数改名字
        int count = memberReadHistoryService.delete(ids);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    @ApiOperation("展示浏览记录")
    @ResponseBody
    public CommonResult<List<MemberReadHistory>> list(Long memberId) {
        List<MemberReadHistory> memberReadHistoryList = memberReadHistoryService.list(memberId);
        return CommonResult.success(memberReadHistoryList);
    }

}
