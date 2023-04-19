package opgave4barchart;
import java.util.ArrayList;
public class BarChartTest {
	public static void main(String[] args)
	{
		BarChart chart = new BarChart();
		
		ArrayList<Integer> list = chart.readValues();
		
		chart.getNames(list);
		chart.printBarChart();
		//System.out.println(chart.findMax(list));
	}
}
