import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

class StudentInfo{
	
	private int sId;
	private String sName;
	private int sPhone;
	private String sEmail;
	private String sAddress;
	private String sInsName;
	
	public StudentInfo(){
		this.sId = 0;
		this.sName = null;
		this.sPhone = 0;
		this.sEmail = null;
		this.sAddress = null;
		this.sInsName = null;
	}
	
	public void setId(Integer sId){
		this.sId = sId;				
	}
	
	public Integer getId(){
		return this.getId();
	}
	
	public void setName(String sName){
		this.sName = sName;				
	}
	
	public String getName(){
		return this.getName();
	}
	
	public void setPhone(Integer sPhone){
		this.sPhone = sPhone;
	}
	
	public Integer getPhone(){
		return this.getPhone();
	}
	
	public void setEmail(String sEmail){
		this.sEmail = sEmail;				
	}
	
	public String getEmail(){
		return this.getEmail();
	}
	
	public void setAddress(String sAddress){
		this.sAddress = sAddress;				
	}
	
	public String getAddress(){
		return this.getAddress();
	}
	
	public void setInstname(String sInsName){
		this.sInsName = sInsName;				
	}
	
	public String getInstname(){
		return this.getInstname();
	}
	
	@Override
	public String toString(){
		return sId+ "\t" + sName + "\t" + sPhone + "\t" + sEmail + "\t" + sAddress + "\t" + sInsName;
	}
}

class Solution{
	public static void main(String[] args) throws IOException {
		
		int option, sIdAuto, uniqueID=0;
		final AtomicInteger count = new AtomicInteger(0);
		
		List<StudentInfo> studentInformation = new ArrayList<StudentInfo>();		
		Scanner in = new Scanner(System.in);
		
		while(true){
			
		System.out.println("Enter Your Option : ->\n");
		System.out.println("For Input Press 1 ");
		System.out.println("For Search id Press 2 ");
		System.out.println("For Delete Press 3 ");
		System.out.println("For Exit Press 4 \n");
		
		option = in.nextInt();
		in.nextLine();
		
		switch(option){
			case 1:
			
				//Taking all the input from the user			
				StudentInfo info =new StudentInfo();
				
				//generating unique id by java from 1 to 2,3..........
				uniqueID = count.incrementAndGet();	
				info.setId(++uniqueID);
							
				System.out.println("Enter student name: \n"); 
				info.setName(in.nextLine());
													
				System.out.println("Enter student phone no: \n");
				info.setPhone(in.nextInt());				
				in.nextLine();
				
				System.out.println("Enter student email id: \n");
				info.setEmail(in.nextLine());
								
				System.out.println("Enter student address: \n");
				info.setAddress(in.nextLine());
								
				System.out.println("Enter student institute name: \n");
				info.setInstname(in.nextLine());			
				
				//Adding all the user inputed data to the studentInfo
				studentInformation.add(info);
				
				System.out.println("StdID\tName\tPhoneNo\tEmail\tAddress\tInstitueName");
				for(StudentInfo sinfo : studentInformation){
					System.out.println(sinfo);
				}
				
								
				//Saving the input to a file names save.txt
				try(FileWriter fw = new FileWriter("save.txt", true);
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter out = new PrintWriter(bw)){
										
					for(StudentInfo sinfo : studentInformation){
						out.println(sinfo);
					}
					
					out.close();
				}catch (Exception e) {
					System.out.println("Please try again");
				}
				
				break;
				
			case 2:		
				
				String words = "2	a	1	a	a	a";
				Scanner typescan; // Not used
				BufferedReader filescan;

				filescan = new BufferedReader(new FileReader("save.txt"));
				String line = "";				
				while((line = filescan.readLine()) != null) {				    
				    if(line.equals(words)) { 
				        System.out.print(line);
				        break;
				    } else {
				        System.out.print("Sorry, could not find it.");
				        break;
				        }
				}
				
				        
				
				/*Scanner txtscan = new Scanner(new File("save.txt"));
				while(txtscan.hasNext()){
					String search = in.nextLine();
					for(StudentInfo sinfo : studentInfo){
						System.out.println(studentInfo.contains(search));						
					}					
				}	*/
				
				/*//input for searching
				System.out.println("Enter the id to search the student : ");
				Scanner searchIn = new Scanner(System.in);
				int searchId = searchIn.nextInt();
				// search the whole array
				for(StudentInfo sinfo : studentInfo){
				    if(sinfo.equals(searchId)){
				        System.out.println("Student is found ");
				    }else{
				    	System.out.println("Student is not available");
				    }
				}*/					
				break;
				
			case 3:
				//Scanner txtdel = new Scanner(new File("save.txt"));
				
				//while(txtdel.hasNextLine()){
					String search = in.nextLine();
					Iterator<StudentInfo> it = studentInformation.iterator();
			        while (it.hasNext()) {
			            if (it.next().getName().equals(search)) {
			                it.remove();
			                break;
			            }
			        }
				//}
				
				break;
			case 4:
				return;
			default:
				System.out.println("Invalid option. Please choose correct option.");
		}
	  }
	}
}