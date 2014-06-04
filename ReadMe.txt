
===================================================
PDFBoxLight - Apache PDFBox port for Android
===================================================
Overview:
------------------------
The Apache PDFBox library is an open source Java tool for working with PDF 
documents. This allows creation of new PDF documents, manipulation 
of existing documents and the ability to extract content from documents.
PDFBox is published under the Apache License, Version 2.0.

If you are interested in contributing to this project , please signup.
If your application is using pdfboxlight library , please share the experience. 

Purpose:
------------------------
PDFBoxLight is the port of Apache PDFBox for Android for the purpose of text extraction from PDF documents. As of now original PDFBox library can not be directly used in Android due to the dependencies to java.awt
Current version is more of a PoC, in the next releases design will be changed to make PDFBox better modular so that the different functionalities are not depending on one another.  

Limitations:
------------------------
    * Only for text extraction from PDF document.
    * Password protected documents are not supported.
    * Encrypted documents are not supported. 	

Usage (Android):
------------------------
    * Build the pdfboxlight and fontboxlight libraries.
    * Add the pdfboxlight ,fontboxlight and commons-logging libraries to the Android project.
    * Use the text extraction APIs as explained in the PDFBox cookbook
    * For example -
			   File tempFile = new File("scratchfile");
			   File pdfFile = new File("my.pdf");
			   tempFile.createNewFile();
			   RandomAccess scratchFile = new RandomAccessFile(tempFile, "rw");
			   PDFTextStripper textStripper = new PDFTextStripper();
			   doc = PDDocument.loadNonSeq(pdfFile, scratchFile);
			   textStripper.setStartPage(4);
			   textStripper.setEndPage(4);			   
			   String data = textStripper.getText(doc);

License:
------------------------
     * Please check the license file

Apache PDFBox
============
The original project is hosted at the Apache Software Foundation  Apache PDFBox is an open source project available for free download at:

http://pdfbox.apache.org/

