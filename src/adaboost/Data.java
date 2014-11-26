package adaboost;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import org.apache.commons.csv.*;
//import java.nio.charset.StandardCharsets;

class DataPoint
{
	double x[];
	String label;
	int y;
	
	public DataPoint(CSVRecord csvRecord,Dataset dataset)
	{	
		String label=csvRecord.get(csvRecord.size()-1);
		Integer y=dataset.Labels.get(label);
		if(y==null)
		{
			this.y=dataset.Labels.size();
			dataset.Labels.put(label, new Integer(this.y));
		}
		else
		{
			this.y=y.intValue();
		}
		int ctr=0;
		this.x=new double[csvRecord.size()-1];
        for(String value : csvRecord)
        {
        	if(ctr<this.x.length)
        	{
        		this.x[ctr++]=Double.parseDouble(value);
        	} 	
        }
	}
	
	public String toString()
	{
		return "Label"+y;
	}
}
class Dataset
{
	HashMap<String, Integer> Labels;// = new HashMap<String, Integer>();
	public Dataset()
	{
		this.Labels = new HashMap<String, Integer>();
	}
}
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
