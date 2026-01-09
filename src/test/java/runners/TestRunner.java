package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
//@CucumberOptions(
//        features = "src/test/resources/features", // pasta dos arquivos .feature
//        glue = {"steps"},
//        plugin = {"pretty", "html:target/cucumber-report.html"},
//        monochrome = true
//)

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps", "utils"},
       // tags = "@adicionarProdutoCarrinho",
        plugin = {"pretty",
                "html:target/cucumber-report.html"}, monochrome = true
)

public class TestRunner {
}
