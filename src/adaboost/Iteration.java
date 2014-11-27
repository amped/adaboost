package adaboost;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.lang.Math;

public class Iteration {
	double D[];
	int h[];
	ArrayList<DataPoint> datapoints;
	double e;
	double beta;
	
	public void set_initD(int num_pts)
	{
		this.D=new double[num_pts];
		Arrays.fill(D, 1.0/num_pts);	
	}
	
	public void set_initD(double[] D)
	{
		this.D=Arrays.copyOf(D, D.length);
	}	
	
	public void init(Data train)
	{
		int num_pts=train.datapoints.size();
		this.datapoints=train.datapoints;
		this.h=new int[num_pts];	
	}
	
	public Iteration(Data train)
	{
		init(train);
		set_initD(this.datapoints.size());
	}
	public Iteration(Data train, double[] D)
	{
		init(train);
		set_initD(D);
	}
	
	public void execute()
	{
		this.set_e();
		this.set_beta();
		this.set_D();
	}
	
	public void set_D()
	{
		for(int i=0;i<this.h.length;++i)
		{
			if(this.h[i]==this.datapoints.get(i).y)
			{
				this.D[i]=this.D[i]*this.beta;
			}
		}
		normalize_D();
	}
	
	public void normalize_D()
	{
		double Dsum=DoubleStream.of(D).sum();

		for(int i=0;i<D.length;++i)
		{
			this.D[i]/=Dsum;
		}
	}
	
	public void set_e()
	{
		this.e=0;
		for(int i=0;i<this.h.length;i++)
		{
			if(this.h[i]!=this.datapoints.get(i).y)
			{
				this.e+=this.D[i];
			}
		}
	}
	public void set_beta()
	{
		this.beta=1/2*Math.log(this.e/(1-this.e));
	}
	public String toString()
	{
		return "Error is"+e;
	}

}
