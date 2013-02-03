/*
 * TeleStax, Open Source Cloud Communications  Copyright 2012.
 * and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.mobicents.protocols.ss7.tools.simulator.tests.cap;

import javolution.xml.XMLFormat;
import javolution.xml.stream.XMLStreamException;

import org.mobicents.protocols.ss7.tools.simulator.common.CapApplicationContextScf;

/**
 * 
 * @author sergey vetyutnev
 * 
 */
public class TestCapScfConfigurationData {

	private static final String CAP_APPLICATION_CONTEXT = "capApplicationContext";

	private CapApplicationContextScf capApplicationContext = new CapApplicationContextScf(CapApplicationContextScf.VAL_CAP_V4_capscf_ssfGeneric);

	
	public CapApplicationContextScf getCapApplicationContext() {
		return capApplicationContext;
	}

	public void setCapApplicationContext(CapApplicationContextScf capApplicationContext) {
		this.capApplicationContext = capApplicationContext;
	}

	
	protected static final XMLFormat<TestCapScfConfigurationData> XML = new XMLFormat<TestCapScfConfigurationData>(TestCapScfConfigurationData.class) {

		public void write(TestCapScfConfigurationData srv, OutputElement xml) throws XMLStreamException {
			xml.add(srv.capApplicationContext.toString(), CAP_APPLICATION_CONTEXT, String.class);
		}

		public void read(InputElement xml, TestCapScfConfigurationData srv) throws XMLStreamException {
			String cpv = (String) xml.get(CAP_APPLICATION_CONTEXT, String.class);
			srv.capApplicationContext = CapApplicationContextScf.createInstance(cpv);
		}
	};

}
