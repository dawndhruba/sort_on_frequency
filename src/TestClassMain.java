import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestClassMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int inputArray[] = {1,2,3,4,5,6,2,3,6,7,8,3,5,9,1,3,1};
		int outputArray[] = {};
		
		List<Integer> inputList = new ArrayList<Integer>();
		for (int i = 0; i < inputArray.length; i++) {
			inputList.add(inputArray[i]);
		}
		
		Collections.sort(inputList);
		
		List<Element> elementList = new ArrayList<Element>();
		
		for (int i = 0; i < inputList.size(); i++) {
			int value = inputList.get(i);
			int freq = 0;
			
			for (Integer integer : inputList) {
				if(integer.intValue() == value) {
					freq++;
				}
			}
			
			Element element = new Element(freq, value);
			
			elementList.add(element);
		}
		
		
		
		String allElement = "";
		for (Integer integer : inputList) {
			allElement += integer;
		}
		
		System.out.println(allElement);
		
		Collections.sort(elementList, new ElementComparator());
		
		String str = "";
		for (Element element : elementList) {
			if(str.length() != 0) {
				str+=", ";
			}
			str+=element.getValue();
			int i=0;
			outputArray[i++] = element.getValue();
		}
		System.out.println(str);
		
		System.out.println(outputArray);
	}
}

class Element {
	private int freq;
	private int value;
	
	public Element(int freq, int value) {
		this.freq = freq;
		this.value = value;
	}
	
	public int getFreq() {
		return freq;
	}
	public void setFreq(int freq) {
		this.freq = freq;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}

class ElementComparator implements Comparator<Element> {
	
	@Override
	public int compare(Element o1, Element o2) {
		// TODO Auto-generated method stub
		if(o1.getFreq() == o2.getFreq()) {
			if(o1.getValue() < o2.getValue()) {
				return -1;
			} else if (o1.getValue() > o2.getValue()) {
				return 1;
			} else {
				return 0;
			}
		} else if (o1.getFreq() > o2.getFreq()) {
			return 1;
		} else if (o1.getFreq() < o2.getFreq()) {
			return -1;
		}
		
		return 0;
	}
}
