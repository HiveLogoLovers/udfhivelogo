package org.apache.hadoop.hive.contrib.udf.hiveudf;

import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.exec.UDFArgumentLengthException;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDF;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory;

@Description(name = "hivelogo",
  value = "_FUNC_(value, ...) - translate a tuple into hive logo.",
  extended = "Example:\n"
          + " > SELECT _FUNC_(value, ...) FROM src;\n")
public class GenericUDFHiveLogo extends GenericUDF {
	  @Override
	  public ObjectInspector initialize(ObjectInspector[] arguments) throws UDFArgumentException {
	    if (arguments.length < 1) {
	      throw new UDFArgumentLengthException(
	          "The function HIVELOGO(v1, v2, ...) takes 1 or more arguments.");
	    }   
	    return PrimitiveObjectInspectorFactory.javaStringObjectInspector;
	  }

	  @Override
	  public Object evaluate(DeferredObject[] arguments) throws HiveException {
		 return HiveLogo.getHiveLogo();
	  }

	  @Override
	  public String getDisplayString(String[] children) {
	    assert (children.length > 0); 
	    return "(" + children[0] + ", ...)";
	  }

}
