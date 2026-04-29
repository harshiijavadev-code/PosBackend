package harshjava.productcutsomerapi.Exception;

public class DuplicateResourceException extends RuntimeException{
    private  final String resourceName;
    private  final String FieldName;
    private final Object FieldValue;
    public DuplicateResourceException(String resourceName, String fieldName, Object fieldValue) {
        this.resourceName = resourceName;
        this.FieldName = fieldName;
        this.FieldValue = fieldValue;
    }
    public String getResourceName(){return  resourceName;}
    public String getFieldName(){return  FieldName;}
    public Object getFieldValue(){return  FieldValue;}

}
