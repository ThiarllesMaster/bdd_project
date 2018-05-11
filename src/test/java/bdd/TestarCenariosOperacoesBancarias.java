package bdd;

import java.util.Arrays;
import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.runner.RunWith;

import cenarios.CenariosOperacoesBancariasDeposito;
import cenarios.CenariosOperacoesBancariasSaque;
import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;

@RunWith(JUnitReportingRunner.class)
public class TestarCenariosOperacoesBancarias extends JUnitStories{

	public TestarCenariosOperacoesBancarias() {
		JUnitReportingRunner.recommendedControls(configuredEmbedder());
		
	}
	
	@Override
	public InjectableStepsFactory stepsFactory() {
		return new InstanceStepsFactory(configuration(), new CenariosOperacoesBancariasSaque(), new CenariosOperacoesBancariasDeposito());
	}

	@Override
	public Configuration configuration() {
		return new MostUsefulConfiguration();
	}


	
	@Override
	protected List<String> storyPaths() {
		return Arrays.asList(
				"estorias/Sacar.story", "estorias/Depositar.story");
	}

	
}
