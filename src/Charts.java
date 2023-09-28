import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class Charts extends gUI{
	
	/**
	 * 
	 * @author Afaruk59
	 */
	
	public void pieChart(String pro, String carb, String fat) {
				
		double p = Double.parseDouble(pro);
		double c = Double.parseDouble(carb);
		double f = Double.parseDouble(fat);
        	
        	//DATA SET
            DefaultPieDataset<String> dataset = new DefaultPieDataset<String>();
            dataset.setValue("Protein", p);
            dataset.setValue("Carb", c);
            dataset.setValue("Fat", f);

            JFreeChart chart = ChartFactory.createPieChart(null, dataset, true, true, false);
            
            chart.setBackgroundPaint(null);
            chart.getLegend().setBackgroundPaint(null);
            chart.getLegend().setItemPaint(Color.GRAY);
            chart.getPlot().setBackgroundPaint(null);
            
            ChartPanel chartPanel = new ChartPanel(chart);
            sPanel2.add(chartPanel);
	}
	
	public void gPieChart(String pro, String carb, String fat) {
		
		int p = Integer.parseInt(pro);
		int c = Integer.parseInt(carb);
		int f = Integer.parseInt(fat);
		
		DefaultPieDataset<String> dataset = new DefaultPieDataset<String>();
        dataset.setValue("Protein", p);
        dataset.setValue("Carb", c);
        dataset.setValue("Fat", f);

        JFreeChart chart = ChartFactory.createPieChart(null, dataset, true, true, false);

        chart.setBackgroundPaint(null);
        chart.getLegend().setBackgroundPaint(null);
        chart.getLegend().setItemPaint(Color.GRAY);
        chart.getPlot().setBackgroundPaint(null);

        ChartPanel chartPnl = new ChartPanel(chart);
        chartPanel.add(chartPnl);    
	}
	
	public void weeklyMacChart(String a, String b, String c, String d, String e, String f, String g, String h, String i, String j, 
			String k, String l, String m, String n, String o, String p, String r, String s, String t, String u, String v) {
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(Double.parseDouble(v), "Protein", "T-7");
		dataset.addValue(Double.parseDouble(u), "Carb", "T-7");
		dataset.addValue(Double.parseDouble(t), "Fat", "T-7");
       
		dataset.addValue(Double.parseDouble(s), "Protein", "T-6");
		dataset.addValue(Double.parseDouble(r), "Carb", "T-6");
		dataset.addValue(Double.parseDouble(p), "Fat", "T-6");
       
		dataset.addValue(Double.parseDouble(o), "Protein", "T-5");
		dataset.addValue(Double.parseDouble(n), "Carb", "T-5");
		dataset.addValue(Double.parseDouble(m), "Fat", "T-5");
       
		dataset.addValue(Double.parseDouble(l), "Protein", "T-4");
		dataset.addValue(Double.parseDouble(k), "Carb", "T-4");
		dataset.addValue(Double.parseDouble(j), "Fat", "T-4");
		
		dataset.addValue(Double.parseDouble(i), "Protein", "T-3");
		dataset.addValue(Double.parseDouble(h), "Carb", "T-3");
		dataset.addValue(Double.parseDouble(g), "Fat", "T-3");
       
		dataset.addValue(Double.parseDouble(f), "Protein", "T-2");
		dataset.addValue(Double.parseDouble(e), "Carb", "T-2");
		dataset.addValue(Double.parseDouble(d), "Fat", "T-2");
       
		dataset.addValue(Double.parseDouble(c), "Protein", "Yesterday");
		dataset.addValue(Double.parseDouble(b), "Carb", "Yesterday");
		dataset.addValue(Double.parseDouble(a), "Fat", "Yesterday");
       
		JFreeChart chart = ChartFactory.createBarChart(null, null, null, dataset);
        
		chart.setBackgroundPaint(null);
		chart.getLegend().setBackgroundPaint(null);
		chart.getLegend().setItemPaint(Color.GRAY);
		chart.getPlot().setBackgroundPaint(null);

		ChartPanel chartPanel = new ChartPanel(chart);
		sPanel4.add(chartPanel);
	}
	
	public void weeklyCalChart(String first, String second, String third, String fourth, String fifth, String sixth, String seventh) {
		
		double mon = Double.parseDouble(first);
		double tue = Double.parseDouble(second);
		double wed = Double.parseDouble(third);
		double thu = Double.parseDouble(fourth);
		double fri = Double.parseDouble(fifth);
		double sat = Double.parseDouble(sixth);
		double sun = Double.parseDouble(seventh);
		
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(sun, "Calorie", "T-7");
        dataset.addValue(sat, "Calorie", "T-6");
        dataset.addValue(fri, "Calorie", "T-5");
        dataset.addValue(thu, "Calorie", "T-4");
        dataset.addValue(wed, "Calorie", "T-3");
        dataset.addValue(tue, "Calorie", "T-2");
        dataset.addValue(mon, "Calorie", "Yesterday");
        
        JFreeChart chart = ChartFactory.createLineChart(null, null, null, dataset, PlotOrientation.VERTICAL, true, true, false );
        
        chart.setBackgroundPaint(null);
        chart.getLegend().setBackgroundPaint(null);
        chart.getLegend().setItemPaint(Color.GRAY);
        chart.getPlot().setBackgroundPaint(null);
        
        ChartPanel chartPanel = new ChartPanel(chart);
        sPanel5.add(chartPanel);	
	}
}
