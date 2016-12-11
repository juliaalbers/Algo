import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class News {
	String m_title;
	String m_description;
	
	@XmlElement
	public void setTitle(String title) {
		m_title = title;
	}
	
	@XmlElement
	public void setDescription(String descpt) {
		m_description = descpt;
	}
	
	public String getTitle() {
		return m_title;
	}
	
	public String getDescription() {
		return m_description;
	}
	
}


