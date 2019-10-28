package com.hand.hiot.app.service;

import com.hand.hiot.domain.entity.OrderExport;
import org.springframework.web.servlet.view.document.AbstractXlsView;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public class ExportOrder extends AbstractXlsView {

        @Override
        protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest request,
                                          HttpServletResponse response) throws Exception {
            // change the file name
            response.setHeader("Content-Disposition", "attachment;filename*=UTF-8''" +
                            URLEncoder.encode("hiot-order-25160.xls","UTF-8"));
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setCharacterEncoding("UTF-8");

            List<OrderExport> orderExportList = (List<OrderExport>)map.get("hiot-order-25160");
            // create excel xls sheet
            Sheet sheet = workbook.createSheet("order");
            sheet.setDefaultColumnWidth(30);

            // create style for header cells
            CellStyle style = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setFontName("微软雅黑");
            style.setFillForegroundColor((short) 13);
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            font.setBold(true);
//            font.setColor(HSSFColor.WHITE.index);
            style.setFont(font);


            // create header row
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("销售订单号");
            header.getCell(0).setCellStyle(style);
            header.createCell(1).setCellValue("公司名称");
            header.getCell(1).setCellStyle(style);
            header.createCell(2).setCellValue("客户名称");
            header.getCell(2).setCellStyle(style);
            header.createCell(3).setCellValue("订单日期");
            header.getCell(3).setCellStyle(style);
            header.createCell(4).setCellValue("订单状态");
            header.getCell(4).setCellStyle(style);
            header.createCell(5).setCellValue("订单金额");
            header.getCell(5).setCellStyle(style);
            header.createCell(6).setCellValue("行号");
            header.getCell(6).setCellStyle(style);
            header.createCell(7).setCellValue("物料编码");
            header.getCell(7).setCellStyle(style);
            header.createCell(8).setCellValue("物料描述");
            header.getCell(8).setCellStyle(style);
            header.createCell(9).setCellValue("产品单位");
            header.getCell(9).setCellStyle(style);
            header.createCell(10).setCellValue("数量");
            header.getCell(10).setCellStyle(style);
            header.createCell(11).setCellValue("销售单价");
            header.getCell(11).setCellStyle(style);
            header.createCell(12).setCellValue("行金额");
            header.getCell(12).setCellStyle(style);
            header.createCell(13).setCellValue("备注");
            header.getCell(13).setCellStyle(style);

            int rowCount = 1;
            for(OrderExport orderExport : orderExportList){
                Row userRow =  sheet.createRow(rowCount++);
                userRow.createCell(0).setCellValue(orderExport.getOrderNumber());
                userRow.createCell(1).setCellValue(orderExport.getCompanyName());
                userRow.createCell(2).setCellValue(orderExport.getCustomerName());
                userRow.createCell(3).setCellValue(orderExport.getOrderDate());
                userRow.createCell(4).setCellValue(orderExport.getOrderStatus());
                userRow.createCell(5).setCellValue(orderExport.getOrderAmount().toString());
                userRow.createCell(6).setCellValue(orderExport.getLineNumber());
                userRow.createCell(7).setCellValue(orderExport.getItemCode());
                userRow.createCell(8).setCellValue(orderExport.getItemDescription());
                userRow.createCell(9).setCellValue(orderExport.getOrderQuantityUom());
                userRow.createCell(10).setCellValue(orderExport.getOrderQuantity().toString());
                userRow.createCell(11).setCellValue(orderExport.getUnitSellingPrice().toString());
                userRow.createCell(12).setCellValue( orderExport.getLineAmount().toString());
                userRow.createCell(13).setCellValue(orderExport.getDescription());

            }

        }
    }
