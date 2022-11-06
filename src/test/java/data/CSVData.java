package data;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CSVData {


    public CSVData(String CSVPath){
        this.CSVPath = CSVPath;
    }

    public String CSVPath;

    public Object[][] dataFromCSV() throws IOException {
        CSVReader csvReader = new CSVReader(new FileReader(CSVPath), ',', '\'', 1);
        List<String[]> list = csvReader.readAll();

        String[][] dataArr = new String[list.size()][]; //used two dimensional array for more data
        dataArr = list.toArray(dataArr);
        return dataArr;
    }
}
