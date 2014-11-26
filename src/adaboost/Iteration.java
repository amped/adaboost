package adaboost;

import java.util.ArrayList;



public class Iteration {
	float D[];
	int h[];
	float e;
	float alpha;
	
	public Iteration(Data train)
	{
		int num_pts=train.datapoints.size();
		D=new float[num_pts];
	}
	
	public String toString()
	{
		return "Error is"+e;
	}
	public static void main(String[] args)
	{
		Data train=new Data("data/iris.data");
		Iteration it=new Iteration(train);
		System.out.println(it);
	}
}
