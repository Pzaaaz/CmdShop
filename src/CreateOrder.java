import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;

import java.io.FileOutputStream;

public class CreateOrder {
    public static String outputFile = "D:\\学习\\Cmdshop\\src\\createordew.xls";
    public static void creatOrder(Order order){
        try {
            // 创建新的Excel 工作簿
            HSSFWorkbook workbook = new HSSFWorkbook();
            // 在Excel工作簿中建一工作表，其名为缺省值
            // 如要新建一名为"效益指标"的工作表，其语句为：
            HSSFSheet sheet = workbook.createSheet("购物订单");
            CellStyle style = workbook.createCellStyle();
            style.setFillForegroundColor(IndexedColors.AQUA.getIndex());
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            HSSFRow row = sheet.createRow((short)0);
            HSSFCell cell01=row.createCell((short)0);
            HSSFCell cell02=row.createCell((short)1);
            HSSFCell cell03=row.createCell((short)2);
            HSSFCell cell04=row.createCell((short)3);
            HSSFCell cell05=row.createCell((short)4);
            HSSFCell cell06=row.createCell((short)5);
            //在单元格中输入一些内容
            cell01.setCellValue("用户");
            cell02.setCellValue("商品");
            cell03.setCellValue("购买数量");
            cell04.setCellValue("商品总价");
            cell05.setCellValue("实付款");
            cell06.setCellValue("订单时间");


            for(int i = 0; i<order.getProduct().length;i++){
                HSSFRow rows = sheet.createRow((short)i+1);
                for(int j = 0 ; j<6 ; j++){
                    HSSFCell cell = rows.createCell((short)j);
                    if (j == 0) {
                        cell.setCellValue(order.getUser().getUsername());
                        //cell.setCellStyle(style);//设置背景色
                    }else if (j==1){
                        cell.setCellValue(order.getProduct()[i].getId());
                    }/*else if (j==2){
                        cell.setCellValue();
                    }else if (j==3){
                        cell.setCellValue();
                    }else if (j==4){
                        cell.setCellValue();
                    }else if (j==5){
                        cell.setCellValue();
                    }*/
                }
            }
            // 在索引0的位置创建行（最顶端的行）


            // 新建一输出文件流
            FileOutputStream fOut = new FileOutputStream(outputFile);
            // 把相应的Excel 工作簿存盘
            workbook.write(fOut);
            fOut.flush();
            // 操作结束，关闭文件
            fOut.close();
            System.out.println("文件生成...");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("已运行 xlCreate() : " + e);
        }
    }
}
