package adaboost;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import org.apache.commons.csv.*;
//import java.nio.charset.StandardCharsets;



public class Data
{
	ArrayList<DataPoint> datapoints;
	Dataset dataset;
	
	public Data(String fpath)
	{
		this.dataset=new Dataset();
	    int di=0;
		try {
			//Given path to data file reads
			File csvData = new File(fpath);
			CSVParser parser = CSVParser.parse(csvData, Charset.defaultCharset(),CSVFormat.RFC4180);
			//int len=Iterables.size(parser);
			//this.datapoints=new DataPoint[len];
			//this.datapoints=new DataPoint[100];
			//this.datapoints=new DataPoint[Iterables.size(parser)];
			datapoints=new ArrayList<DataPoint>(100);
			
			System.out.println("hi"+parser.toString());
			 for (CSVRecord csvRecord : parser) {
				 this.datapoints.add(new DataPoint(csvRecord,dataset));
			 }
//			 for(DataPoint dp: datapoints)
//			 {
//				 System.out.println(dp);
//			 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
