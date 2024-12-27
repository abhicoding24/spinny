package com.spinny.service;

import com.spinny.entity.CarEvaluation;
import com.spinny.repository.CarEvaluationRepository;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.ss.usermodel.*;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CarEvaluationUploadService {

    @Autowired
    private CarEvaluationRepository carEvaluationRepository;

    public void uploadExcel(MultipartFile file) throws IOException {
        Workbook workbook = new XSSFWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0); // Get the first sheet
        Iterator<Row> rowIterator = sheet.iterator();

        List<CarEvaluation> carEvaluations = new ArrayList<>();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // Skip the header row (optional)
            if (row.getRowNum() == 0) {
                continue;
            }

            // Read data from Excel row (columns: Car Company Name, Year of Manufacturing, Min Driven Km, Max Driven Km, Min Price, Max Price)
            String carCompanyName = row.getCell(0).getStringCellValue();
            Integer yearOfManufacturing = (int) row.getCell(1).getNumericCellValue();
            Integer minDrivenKm = (int) row.getCell(2).getNumericCellValue();
            Integer maxDrivenKm = (int) row.getCell(3).getNumericCellValue();
            Double approxCarAmountMin = row.getCell(4).getNumericCellValue();
            Double approxCarValueMax = row.getCell(5).getNumericCellValue();

            CarEvaluation carEvaluation = new CarEvaluation();
            carEvaluation.setCarCompanyName(carCompanyName);
            carEvaluation.setYearOfManufacturing(yearOfManufacturing);
            carEvaluation.setMinDrivenKm(minDrivenKm);
            carEvaluation.setMaxDrivenKm(maxDrivenKm);
            carEvaluation.setApproxCarAmountMin(approxCarAmountMin);
            carEvaluation.setApproxCarValueMax(approxCarValueMax);

            carEvaluations.add(carEvaluation);
        }

        // Save data in batch
        carEvaluationRepository.saveAll(carEvaluations);
        workbook.close();
    }

    public List<CarEvaluation> getEstimation(int yearOfManufacturing, int maxDrivenKm, int minDrivenKm){
        List<CarEvaluation> carEvaluation = carEvaluationRepository.findCarByYearAndKmRange(yearOfManufacturing,minDrivenKm,maxDrivenKm);
        return carEvaluation;
    }

    // Helper method to safely get a String value from a cell
//    private String getStringCellValue(Row row, int cellIndex) {
//        Cell cell = row.getCell(cellIndex);
//        if (cell != null) {
//            switch (cell.getCellType()) {
//                case STRING:
//                    return cell.getStringCellValue();
//                case NUMERIC:
//                    return String.valueOf(cell.getNumericCellValue());
//                case BOOLEAN:
//                    return String.valueOf(cell.getBooleanCellValue());
//                case FORMULA:
//                    return cell.getCellFormula();
//                default:
//                    return "";
//            }
//        }
//        return "";
//    }
//
//    // Helper method to safely get a Numeric value from a cell
//    private Double getNumericCellValue(Row row, int cellIndex) {
//        Cell cell = row.getCell(cellIndex);
//        if (cell != null) {
//            switch (cell.getCellType()) {
//                case NUMERIC:
//                    return cell.getNumericCellValue();
//                case STRING:
//                    try {
//                        return Double.parseDouble(cell.getStringCellValue());
//                    } catch (NumberFormatException e) {
//                        return 0.0;
//                    }
//                case BOOLEAN:
//                    return cell.getBooleanCellValue() ? 1.0 : 0.0;
//                default:
//                    return 0.0;
//            }
//        }
//        return 0.0;
//    }
}
