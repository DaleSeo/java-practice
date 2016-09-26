package seo.dale.practice.javax.xml.bind;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Arrays;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JaxbTest {

	@Test
	public void testMarshal() throws JAXBException {
		Config bean = new Config();
		bean.setActivation(true);
		bean.setIpList(Arrays.asList("127.0.0.1", "127.0.0.2", "127.0.0.3"));

		JAXBContext context = JAXBContext.newInstance(Config.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		marshaller.marshal(bean, baos);
		System.out.println(baos);

		String[] tokens = baos.toString().split("\n");
		assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>", tokens[0].trim());
		assertEquals("<config>", tokens[1].trim());
		assertEquals("<activation>true</activation>", tokens[2].trim());
		assertEquals("<ipList>", tokens[3].trim());
		assertEquals("<item>127.0.0.1</item>", tokens[4].trim());
	}

	@Test
	public void testUnmarshal() throws JAXBException {
		InputStream inputStream = getClass().getResourceAsStream("/xml/config.xml");
		System.out.println(inputStream);
		
		JAXBContext context = JAXBContext.newInstance(Config.class);
		Unmarshaller unmarshaller = context.createUnmarshaller(); 
		Config bean = (Config) unmarshaller.unmarshal(inputStream);
		System.out.println(bean);

		assertTrue(bean.isActivation());
		assertEquals(Arrays.asList("127.0.0.1", "127.0.0.2", "127.0.0.3"), bean.getIpList());
	}

}
