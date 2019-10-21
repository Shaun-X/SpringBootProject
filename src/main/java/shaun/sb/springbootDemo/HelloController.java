package shaun.sb.springbootDemo;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	private static ArrayList<DevOpsStudent> students = new ArrayList();
	@Autowired
	private helloService service;
@RequestMapping("/hello")
	public String hello() {
		return service.helloService();
	}
@GetMapping(path="/hello/bean")
	public String Bean() {
		return new MyFirstBean("This is from bean").toString();
	}
@RequestMapping(method=RequestMethod.POST, path="/addStudent")
	public String addStudents(int id, String name, String joinDate) {
	DevOpsStudent student = new DevOpsStudent(id, name, joinDate);
	students.add(student);
	return "Student: " + name + " with id number: "+id+" joined on: " + joinDate;
}

@RequestMapping(method=RequestMethod.GET, path="/showStudent")
	public String showStudent(){
	String tempStud = "";
	for(int i = 0; i < students.size(); i++) {
		tempStud += students.get(i).toString()+"\n";
	}
	if(tempStud == "")return "No Students";
	return tempStud;
}
@RequestMapping(method=RequestMethod.DELETE, path="/deleteStudent")
	public String deleteStudent(int id) {
		int index = -1;
		for(DevOpsStudent element:students) {
			if(element.getStudentId() == id){
				index = students.indexOf(element);
			}		
		}	
		if (index == -1) return "Can not find this student with the given id.";
		else {
			students.remove(index);
		}
		return "Removed.";
}
@RequestMapping(method=RequestMethod.PUT, path="/editStudent")
	public String editStudent(int id, String newName, String newDate) {
	int index = -1;
	for(DevOpsStudent element:students) {
		if(element.getStudentId() == id){
			index = students.indexOf(element);
		}		
	}
	if (index == -1) return "Can not find this student with the given id.";
	else {
		students.get(index).setStudentName(newName);
		students.get(index).setJoinDate(newDate);
	}
	return "Student with id: " + id + "has been modified on " + newDate;
}
}

@Component
class helloService{
	public String helloService() {
		return "What's Up!!";
	}
}
