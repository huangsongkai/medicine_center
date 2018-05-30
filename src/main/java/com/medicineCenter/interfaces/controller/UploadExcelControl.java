package com.medicineCenter.interfaces.controller;

import com.medicineCenter.model.dataObject.Experts;
import com.medicineCenter.service.ExpertsCrudService;
import com.medicineCenter.util.ExportExcelUtil;
import com.medicineCenter.util.ImportExcelUtil;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
//@RequestMapping("/uploadExpertsExcel/{departments}")
public class UploadExcelControl {

	@Resource
	ExpertsCrudService expertsCrudService;

	private Result result = new Result();
	@RequestMapping(value = "/uploadExpertsExcel/{departments}", method = RequestMethod.GET)
	@ResponseBody
	public Result viewList(HttpServletRequest request, HttpServletResponse response, @PathVariable String departments) throws IOException {

        OutputStream os = null;
        Workbook wb = null;    //工作薄
        try {
            //数据库取值
            List<Experts> expertes = expertsCrudService.selectByDepartment(departments);
            //导出Excel文件数据
            ExportExcelUtil util = new ExportExcelUtil();
            File file =util.getExcelDemoFile("classes/ExcelDemo/专家信息.xlsx");
            String sheetName="sheet1";
            wb = writeNewExcel(file, sheetName, expertes);
            String fileName= departments+"专家信息"+".xlsx";
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-disposition", "attachment;filename="+ URLEncoder.encode(fileName, "utf-8"));
            os = response.getOutputStream();
            wb.write(os);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            os.flush();
            os.close();
            wb.close();
        }


		result.setSuccess("导出成功",null);
		return result;
	}

	public <T> Workbook writeNewExcel(File file,String sheetName,List<T> lis) throws Exception {
        Workbook wb = null;
        Row row = null;
        Cell cell = null;

        FileInputStream fis = new FileInputStream(file);
        wb = new ImportExcelUtil().getWorkbook(fis, file.getName());    //获取工作薄
        Sheet sheet = wb.getSheet(sheetName);

        //循环插入数据
        int lastRow = sheet.getLastRowNum() - 2;    //插入数据的数据ROW
        CellStyle cs = setSimpleCellStyle(wb);    //Excel单元格样式
        for (int i = 0; i < lis.size(); i++) {
            row = sheet.createRow(lastRow + i); //创建新的ROW，用于数据插入
            //按项目实际需求，在该处将对象数据插入到Excel中
            T vo = lis.get(i);
            if (null == vo) {
                break;
            }
            int index = 0;
            for (Field field : vo.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                System.out.println(field.getName() + ":" + field.get(vo));
                cell = row.createCell(index);
                cell.setCellValue(field.get(vo).toString());
                cell.setCellStyle(cs);
                index++;
            }
        }
        return wb;
    }

	/**
	 * 描述：设置简单的Cell样式
	 * @return
	 */
	public  CellStyle setSimpleCellStyle(Workbook wb){
		CellStyle cs = wb.createCellStyle();
		cs.setBorderBottom(CellStyle.BORDER_THIN); //下边框
		cs.setBorderLeft(CellStyle.BORDER_THIN);//左边框
		cs.setBorderTop(CellStyle.BORDER_THIN);//上边框
		cs.setBorderRight(CellStyle.BORDER_THIN);//右边框
		cs.setAlignment(CellStyle.ALIGN_CENTER); // 居中
		return cs;
	}

	public String importExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		commonsMultipartResolver.setDefaultEncoding("utf-8");
		MultipartHttpServletRequest multipartRequest = commonsMultipartResolver.resolveMultipart(request);
		System.out.println("通过传统方式form表单提交方式导入excel文件！");

		InputStream in = null;
		List<List<java.lang.Object>> listob = null;
		MultipartFile file = multipartRequest.getFile("upfile");
		if (file.isEmpty()) {
			throw new Exception("文件不存在！");
		}
		in = file.getInputStream();
		listob = new ImportExcelUtil().getBankListByExcel(in, file.getOriginalFilename());
		in.close();

		//该处可调用service相应方法进行数据保存到数据库中，现只对数据输出
		for (int i = 0; i < listob.size(); i++) {
//			List<java.lang.Object> lo = listob.get(i);
//			KyInsurance insurance = new KyInsurance();
//			KyAccident.class.getFields();//
//			insurance.setBdh(String.valueOf(lo.get(1)));
//			insurance.setCph(String.valueOf(lo.get(2)));
//			insurance.setBbxr(String.valueOf(lo.get(3)));
//			insurance.setBxqq(String.valueOf(lo.get(4)));
//			insurance.setBxzq(String.valueOf(lo.get(5)));
//			insurance.setZbe(String.valueOf(lo.get(6)));
//			insurance.setZbf(String.valueOf(lo.get(7)));
//			insurance.setLrsj(String.valueOf(lo.get(8)));
//			bxDao.save(insurance);
//			System.out.println("打印信息--> ");
		}
		result.setSuccess("导出成功", null);
		return "bx/insurance_list";
	}


}
