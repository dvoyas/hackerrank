import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class BinaryNumbers {

    static int shiftRight(){
        byte five = 0b00010100;
        System.out.println(Integer.toBinaryString(five));
        return five>>>1;

    }

    public static void main (String[] args){
        System.out.println(Integer.toBinaryString(shiftRight()));
    }
}
