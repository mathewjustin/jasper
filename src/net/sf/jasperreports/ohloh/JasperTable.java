/*
 * JasperReports - Free Java Reporting Library.
 * Copyright (C) 2001 - 2014 TIBCO Software Inc. All rights reserved.
 * http://www.jaspersoft.com
 *
 * Unless you have purchased a commercial license agreement from Jaspersoft,
 * the following license terms apply:
 *
 * This program is part of JasperReports.
 *
 * JasperReports is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JasperReports is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with JasperReports. If not, see <http://www.gnu.org/licenses/>.
 */
package net.sf.jasperreports.ohloh;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * @deprecated To be removed.
 * @author sanda zaharia (shertage@users.sourceforge.net)
 */
public class JasperTable 
{
public static void main(String[] args) throws JRException, FileNotFoundException {
	List<Person>listOfPersons=new ArrayList<>();
	Logger log = Logger.getLogger("net.sf.jasperreports.engine.fill.BaseReportFiller");
	
	log.addHandler(new StreamHandler(System.out, new SimpleFormatter()));

	Person p1=new Person("Ahmed", "1");
	Person p2=new Person("Divya", "2");
	Person p3=new Person("Ananya", "3");
	Person p4=new Person("Don", "4");
    listOfPersons.addAll(Arrays.asList(p1,p2,p3,p4));
    
    JRBeanCollectionDataSource jrbean=new JRBeanCollectionDataSource(listOfPersons);
    
    Map<String,Object>parameters=new HashMap<>();
    parameters.put("personDataset", jrbean);
    /*/C:/Users/jumathew/JaspersoftWorkspace/JasperReportsSamples*/
    JasperPrint jprint=JasperFillManager.fillReport("./persons/Persons.jasper", parameters);

    JasperPrint jasperPrint = JasperFillManager.fillReport("./persons/Persons.jasper",parameters, new JREmptyDataSource());
  
    JasperExportManager.exportReportToPdfFile(jasperPrint, "c:\\newReport.pdf");
  
 }	


}
