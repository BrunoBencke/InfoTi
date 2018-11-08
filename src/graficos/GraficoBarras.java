package graficos;
import entidades.Produto;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraficoBarras {

    //criar o dataset
    public CategoryDataset createDataSet(ArrayList<Produto> produtos) {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for (Produto produto : produtos) {
            dataSet.addValue(produto.getEstoque(), produto.getNome(), "");
        }
        return dataSet;
    }
    
    //criar o gráfico de barras
    public JFreeChart createBarChart(CategoryDataset dataSet) {
        JFreeChart graficoBarras = ChartFactory.createBarChart("Produtos por Estoque", "", "Estoque", dataSet, PlotOrientation.VERTICAL, true, false, false);
        return graficoBarras;
    }
    
    //criar o gráfico completo
    public ChartPanel criarGrafico(ArrayList<Produto> produtos) {
        CategoryDataset dataset = this.createDataSet(produtos);
        JFreeChart grafico = this.createBarChart(dataset);
        ChartPanel painel = new ChartPanel(grafico);
        painel.setPreferredSize(new Dimension(400, 400));
        return painel;
    }
}
