package com.xml;



import org.eclipse.persistence.jaxb.MarshallerProperties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;



        /*
         * Class to check marshall and unmarshall
         * both xml and json support
         */
        public class JAXBExample{
            public static void main(String args[]){
                // Create the employee list
                Employees empList = new Employees();
                EmployeeData data1 = new EmployeeData("1","Charlie","Chaplin",35,2000.00);
                EmployeeData data2 = new EmployeeData("2","John","Rambo",36,2500.00);
                empList.add(data1);
                empList.add(data2);

                try{
                    System.setProperty("javax.xml.bind.context.factory","org.eclipse.persistence.jaxb.JAXBContextFactory"); //for json
                    // Marshall
                    JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class,EmployeeData.class);
                    Marshaller marshaller = jaxbContext.createMarshaller();
                    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

                    marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");//for json
                    marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);//for json 

                    marshaller.marshal(empList, new File("./employees.xml"));
                    //marshaller.marshal(empList, System.out);

                    empList.getEmployees().clear();
                    // Unmarshall
                    File file = new File("./employees.xml");
                    jaxbContext = JAXBContext.newInstance(Employees.class,EmployeeData.class);
                    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                    unmarshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");//for json
                    empList = (Employees) unmarshaller.unmarshal(file);
                    System.out.println(empList);

                } catch (JAXBException jaxbe){
                    jaxbe.printStackTrace();
                } catch (Exception fnfe) {
                    fnfe.printStackTrace();
                }
            }
        }




