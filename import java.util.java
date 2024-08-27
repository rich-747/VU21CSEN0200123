import java.util.ArrayList;
import java.util.Random;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

public class Test {


@POST
@Path("/numbers/e")
@Produces("application/json")
public Response evenNumbers()
throws Exception {

Gson gson = new Gson();
JSONObject responseObject = new JSONObject();
JSONObject exObject = new JSONObject();
ArrayList list = new ArrayList();
ArrayList list2 = new ArrayList();
int num=0;
int tot=0;
for (int i=1; i<=winnumber; i++)  
{  
//logic to check if the number is even or not  
//if i%2 is equal to zero, the number is even  
if (i%2==0)  
{
list.add(i);
num++;
tot=+i;
}
}
ArrayList windowsprevStatel = new ArrayList();

responseObject.put("numbers",list);
responseObject.put("windowsprevState", list2);
responseObject.put("windowCurrState", list);
responseObject.put("avg", tot/num);
return Response.status(200).entity(gson.toJson(responseObject)).build();
}

@POST
@Path("/test/{numberid}")
@Produces("application/json")
public Response allNumbers(@PathParam("numberid") String numberid)
throws Exception {

Gson gson = new Gson();
JSONObject responseObject = new JSONObject();
JSONObject exObject = new JSONObject();
ArrayList list = new ArrayList();
ArrayList list2 = new ArrayList();
if (numberid.equals("even"))
{
int number=100;  
for (int i=1; i<=number; i++)  
{  
if (i%2==0)  
{
list.add(i);
}
}
}

else if (numberid.equals("fibo"))
{
int n1=0,n2=1,n3,i,count=10;    
System.out.print(n1+" "+n2);
   
for(i=2;i<count;++i)  
{    
 n3=n1+n2;    
 list.add(n3);  
 n1=n2;    
 n2=n3;    
}    
 
}


else if (numberid.equals("primes"))
{
int num = 29;
   boolean flag = false;

   if (num == 0 || num == 1) {
       flag = true;
   }

   for (int i = 2; i <= num / 2; ++i) {

   
     if (num % i == 0) {
     list.add(num);
     }
   }

 
}
else if (numberid.equals("r"))
{
       Random rand = new Random();
       int low, high;
       int n;
       int number;
for (int i = 0; i < n; i++) {
           number = rand.nextInt((high + 1) - low) + low;
          list.add(number);
       }
}

responseObject.put("numbers",list);

return Response.status(200).entity(gson.toJson(responseObject)).build();
}
}