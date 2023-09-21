import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class CustomProgram {
    public static void main(String[] args) throws Exception {
	// reads the provided customPage.html into list
	Scanner in = new Scanner(new File("customPage.html"));
	ArrayList<String> list = new ArrayList<>();
	while(in.hasNextLine()) list.add(in.nextLine());


	// update list to reflect changes requested through command line args
	// TODO: Complete this section
	String name=null;
	String background;
	if(args.length > 0)
	    for(String arg : args[0].split("&")) {
		String[] keyValuePair = arg.split("=");
		switch(keyValuePair[0]) {
		case "name":
		    // TODO: when a greeting is selected (below), this
		    // arguments's value should be displayed in that greeting
		    if(keyValuePair.length==2){
		    	name = keyValuePair[1];
		    }else{
		    name = null;
		    }
		break;
		case "background":
		    // TODO: when background="Dark", the body's color should be
		    // set to white and it's background-color should be set to
		    // black (the opposite of how they are set for "Light" by
		    // default.
		    if(keyValuePair[1].equals("Dark")){
		    	list.set(list.indexOf("      background-color: white;"),"      background-color: black;");
	            list.set(list.indexOf("      color: black;"),"      color: white;");

		    }
		    break;
		case "Greeting":
		    // TODO: when this argument is present and =true, an <h1>
		    // element containing the text "Welcome Stranger" should
		    // be inserted as the first element within the body.  If
		    // a non-empty-string name is provided (see above), that
		    // name should be used in place of the word Stranger in
		    // this greeting.
		    if(name==null){
		    list.set(list.indexOf("    <h1>Page Customization Options:</h1>"),"<h1>Welcome Stranger</h1>");
		    }else{
		    list.set(list.indexOf("    <h1>Page Customization Options:</h1>"),"<h1>Welcome "+ name + "</h1>");
		    }
		    break;
		case "SuppressOptions":
		    // TODO: when this argument is present and =true, the
		    // customization controls should be removed from the page.
		    // Everything from and including the <h1> label through the
		    // final </ul> should be omitted to accomplish this.
		    int a = list.indexOf("    <h1>Page Customization Options:</h1>");
		    int b = list.indexOf("    </ul>");

		   java.util.List<String> sub = list.subList(a,b+1);
		    list.removeAll(sub);
		    break;
		}
    }
	
	// print the resulting html out to system.out (standard out)
	for(String line : list)
	    System.out.println(line);
    }
}
