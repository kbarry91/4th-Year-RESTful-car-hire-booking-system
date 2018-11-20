package ie.gmit.sw.utils;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import ie.gmit.sw.models.Booking;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
//import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;

//import javax.xml.bind.Unmarshaller;
/*
 *  Adapted from data externalization lab
 *  
 *  */
public class BookingMarshal {

	public BookingMarshal() {
	} // empty constructor

	protected String getBookingAsXML(Booking booking) {
		// Marshal the Booking into XML
		StringWriter sw = new StringWriter();
		Marshaller m;

		try {
			JAXBContext jc = JAXBContext.newInstance("ie.gmit.sw.models");
			m = jc.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(booking, sw);
		} catch (JAXBException e) {
			System.out.println("Error marshalling booking");
			e.printStackTrace();
		}

		return sw.toString();
	}// end getBookingAsXML

	protected Booking getBookingFromXML(String input) {
		System.out.println("DEBUG/BookingMarshel/getBookingFromXML");
		// Unmarshal the Booking from XML
		StringReader sr1 = new StringReader(input);
		Unmarshaller um1;
		Booking bookingFromXml = null;

		try {
			JAXBContext jc = JAXBContext.newInstance("ie.gmit.sw.models");
			um1 = jc.createUnmarshaller();
			StreamSource source1 = new StreamSource(sr1);
			JAXBElement<Booking> bookingElement1 = um1.unmarshal(source1, Booking.class);
			bookingFromXml = (Booking) bookingElement1.getValue();
		} catch (JAXBException e) {
			System.out.println("Error unmarshalling booking object");
			e.printStackTrace();
		}

		return bookingFromXml;
	}

}
