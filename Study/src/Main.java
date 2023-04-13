import com.pixelmed.dicom.AttributeList;



public class Main {

    public static AttributeList list = new AttributeList();

    public static void main(String[] args) {
        String dicomFile = "C:\\Users\\Anon\\Desktop\\Images\\DIC";


        try {
            list.read(dicomFile);
            System.out.println(list.toString());



        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}