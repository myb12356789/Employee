package com.sontan.myb.listener;//package com.sontan.myb.listener;
//
//import com.alibaba.excel.context.AnalysisContext;
//import com.alibaba.excel.event.AnalysisEventListener;
//import com.sontan.myb.entity.Commodity;
//import com.sontan.myb.entity.Result;
//import com.sontan.myb.service.CommodityService;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class CommodityListener extends AnalysisEventListener<Commodity> {
//    private CommodityService commodityService;
//
//    public CommodityListener(CommodityService commodityService) {
//        this.commodityService = commodityService;
//    }
//
//    public CommodityListener() {
//    }
//    private List<Commodity> datas = new ArrayList<>();
//
//    @Override
//    public void invoke(Commodity commodity, AnalysisContext analysisContext) {
//            datas.add(commodity);
//
//    }
//
//
//
//    @Override
//    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
//
//    }
//}