package seo.dale.practice.javax.xml.bind;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "config")
@XmlAccessorType(XmlAccessType.FIELD)
public class Config {

	@XmlElement(name = "activation")
	private boolean activation;

	@XmlElementWrapper(name = "ipList")
	@XmlElement(name = "item")
	private List<String> ipList;

	public boolean isActivation() {
		return this.activation;
	}

	public void setActivation(boolean activation) {
		this.activation = activation;
	}

	public List<String> getIpList() {
		return this.ipList;
	}

	public void setIpList(List<String> ipList) {
		this.ipList = ipList;
	}

	@Override
	public String toString() {
		return "activation=" + activation + ", ipList=" + ipList;
	}

}
