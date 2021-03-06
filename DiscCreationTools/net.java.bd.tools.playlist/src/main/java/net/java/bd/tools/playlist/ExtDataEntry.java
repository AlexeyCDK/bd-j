/*  
 * Copyright (c) 2008, Sun Microsystems, Inc.
 * 
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 
 *  * Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *  * Neither the name of Sun Microsystems nor the names of its contributors
 *    may be used to endorse or promote products derived from this software
 *    without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 *  Note:  In order to comply with the binary form redistribution 
 *         requirement in the above license, the licensee may include 
 *         a URL reference to a copy of the required copyright notice, 
 *         the list of conditions and the disclaimer in a human readable 
 *         file with the binary form of the code that is subject to the
 *         above license.  For example, such file could be put on a 
 *         Blu-ray disc containing the binary form of the code or could 
 *         be put in a JAR file that is broadcast via a digital television 
 *         broadcast medium.  In any event, you must include in any end 
 *         user licenses governing any code that includes the code subject 
 *         to the above license (in source and/or binary form) a disclaimer 
 *         that is at least as protective of Sun as the disclaimers in the 
 *         above license.
 * 
 *         A copy of the required copyright notice, the list of conditions and
 *         the disclaimer will be maintained at 
 *         https://hdcookbook.dev.java.net/misc/license.html .
 *         Thus, licensees may comply with the binary form redistribution
 *         requirement with a text file that contains the following text:
 * 
 *             A copy of the license(s) governing this code is located
 *             at https://hdcookbook.dev.java.net/misc/license.html
 */


package net.java.bd.tools.playlist;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * BD-ROM Part 3-1 5.3.8 ExtensionData ExtDataEntry item.
 */
@XmlType(propOrder={"ID1", "ID2"})
public class ExtDataEntry {
    private int id1;
    private int id2;
    // Note - extentionDataStartAddress and extentionDataLength are
    // read in and written out by ExtensionData.java
    //private long extDataStartAddress;
    //private long extDataLength;
    
    public void readObject(DataInputStream din) throws IOException {
        // 16 bit id1                                   2
        // 16 bit id2                           2
        
        // 
        // 32 bit extDataStartAddress   4 unsigned
        // 32 bit extDataLength         4 unsigned
        // Note - extentionDataStartAddress and extentionDataLength are
        // read in and written out by ExtensionData.java        
        setID1((int) din.readShort());
        setID2((int) din.readShort());
        
        //byte[] extDataStartAddressBytes = new byte[4];
        //byte[] extDataLengthBytes  = new byte[4];     
        //din.readFully(extDataStartAddressBytes);
        //setExtDataStartAddress(UnsignedIntHelper.convertToLong(extDataStartAddressBytes));
        //din.readFully(extDataLengthBytes);
        //setExtDataLength(UnsignedIntHelper.convertToLong(extDataLengthBytes));
    }
    
    public void writeObject(DataOutputStream dout) throws IOException {
        dout.writeShort(getID1());
        dout.writeShort(getID2());
        //dout.write(UnsignedIntHelper.convertToBytes(getExtDataStartAddress()));
        //dout.write(UnsignedIntHelper.convertToBytes(getExtDataLength()));
    }

    @XmlJavaTypeAdapter(HexStringIntegerAdapter.class)    
    public Integer getID1() {
        return id1;
    }

    public void setID1(Integer id1) {
        this.id1 = id1;
    }

    @XmlJavaTypeAdapter(HexStringIntegerAdapter.class)    
    public Integer getID2() {
        return id2;
    }

    public void setID2(Integer id2) {
        this.id2 = id2;
    }
    
}
