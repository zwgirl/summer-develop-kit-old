@Module
package org.w3c.dom; 

//File: dom.idl

//#ifndef _DOM_IDL_
//#define _DOM_IDL_
//
//#pragma prefix "w3c.org"
//module dom
//{

//valuetype String sequence<unsigned short>;
//
//typedef  unsigned long long DOMTimeStamp;

//public interface DocumentType;
//public interface Document;
//public interface NodeList; 
//public interface NamedNodeMap;
//public interface Element;

public native class DOMException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	// ExceptionCode
	public native static final /*unsigned */short   INDEX_SIZE_ERR  = 1;
	public native static final /*unsigned */short   DOMSTRING_SIZE_ERR  = 2;
	public native static final /*unsigned */short   HIERARCHY_REQUEST_ERR     = 3;
	public native static final /*unsigned */short   WRONG_DOCUMENT_ERR  = 4;
	public native static final /*unsigned */short   INVALID_CHARACTER_ERR     = 5;
	public native static final /*unsigned */short   NO_DATA_ALLOWED_ERR = 6;
	public native static final /*unsigned */short   NO_MODIFICATION_ALLOWED_ERR  = 7;
	public native static final /*unsigned */short   NOT_FOUND_ERR  = 8;
	public native static final /*unsigned */short   NOT_SUPPORTED_ERR  = 9;
	public native static final /*unsigned */short   INUSE_ATTRIBUTE_ERR = 10;
	// Introduced in DOM Level 2:
	public native static final /*unsigned */short   INVALID_STATE_ERR  = 11;
	// Introduced in DOM Level 2:
	public native static final /*unsigned */short   SYNTAX_ERR    = 12;
	// Introduced in DOMfinal vel 2:
	public native static final /*unsigned */short   INVALID_MODIFICATION_ERR    = 13;
	// Introduced in DOM Level 2:
	public native static final /*unsigned */short   NAMESPACE_ERR  = 14;
	// Introduced in DOM Level 2:
	public native static final /*unsigned */short   INVALID_ACCESS_ERR  = 15;
	
	// Introduced in DOM Level 3:
//	const unsigned 
	public native static final short   VALIDATION_ERR  = 16;
	// Introduced in DOM Level 3:
//	const unsigned 
	public native static final short   TYPE_MISMATCH_ERR  = 17;
 /*unsigned */short  code;
}

//Introduced in DOM Level 3:
public native interface DOMStringList {
	public native String item(final /*unsigned*/ long index);
//	readonly attribute unsigned 
	public native long  length{}
	public native boolean contains(final String str);
}


public native interface DOMImplementation {
	public native boolean hasFeature(final String feature, final String version);
	// Introduced final DOM Level 2:
	public native DocumentType createDocumentType(final String qualifiedName, final String publicId, final String systemId) throws DOMException;
	// Introduced final DOM Level 2:
	public native Document createDocument(final String namespaceURI, final String qualifiedName, final DocumentType doctype) throws DOMException;
}

public native interface DocumentFragment extends Node {
}

public native interface Node {

	// NodeType
	public native static final short   ELEMENT_NODE   = 1; 
	public native static final short   ATTRIBUTE_NODE  = 2;
	public native static final short   TEXT_NODE    = 3;
	public native static final short   CDATA_SECTION_NODE  = 4;
	public native static final short   ENTITY_REFERENCE_NODE     = 5;
	public native static final short   ENTITY_NODE   = 6;
	public native static final short   PROCESSING_INSTRUCTION_NODE  = 7;
	public native static final short   COMMENT_NODE   = 8;
	public native static final short   DOCUMENT_NODE  = 9;
	public native static final short   DOCUMENT_TYPE_NODE  = 10;
	public native static final short   DOCUMENT_FRAGMENT_NODE     = 11;
	public native static final short   NOTATION_NODE  = 12;

 	// readonly attribute 
 	public native String nodeName{}
 	//     attribute 
 	public native String nodeValue{}
     // throws DOMException on setting
     // throws DOMException on retrieval

 	// readonly attribute /*unsigned */
 	public native short nodeType{}
 	// readonly attribute 
 	public native Node parentNode{}
 	// readonly attribute 
 	public native NodeList childNodes{}
 	// readonly attribute 
 	public native Node firstChild{}
 	// readonly attribute 
 	public native Node lastChild{}
 	// readonly attribute 
 	public native Node previousSibling{}
 	// readonly attribute 
 	public native Node nextSibling{}
 	// readonly attribute 
 	public native NamedNodeMap attributes{}
 	// Modified in DOM Level 2:
 	// readonly attribute 
 	public native Document ownerDocument{}
 	public native Node insertBefore(final Node newChild, final Node refChild) throws DOMException;
 	public native Node replaceChild(final Node newChild, final Node oldChild) throws DOMException;
 	public native Node removeChild(final Node oldChild) throws DOMException;
 	public native Node appendChild(final Node newChild) throws DOMException;
 	public native boolean hasChildNodes();
 	public native Node cloneNode(final boolean deep);
 	// Modified in DOM Level 2:
 	public native void normalize();
 	// Introduced in DOM Level 2:
 	public native boolean isSupported(final String feature, final String version);
 	// Introduced in DOM Level 2:
 	// readonly attribute 
 	public native String namespaceURI{}
 	// Introduced in DOM Level 2:
 	//   attribute
 	public native String prefix{}
   // throws DOMException on setting

 	// Introduced in DOM Level 2:
 	// readonly attribute 
 	public native String localName{}
 	// Introduced in DOM Level 2:
 	public native boolean hasAttributes();
 	
    public Template template{ 
    	&{ 
    		return this["__template"] == undefined ? null : (Template)this["__template"];
    	} 
    	+{
    		this["__template"] = value;
    	}
    }
    
    public ItemsConfig itemsConfig{
    	&{
    		return this["__itemsConfig"] == undefined ? null : (ItemsConfig)this["__itemsConfig"];
    	}
    	+{
    		this["__itemsConfig"] = value; 
    	}
    }
    
    public DataContext dataContext{
    	&{
    		if(this["__dataContext"] === undefined){
    			if(this.parentNode == null){
    				return (DataContext)(this["__dataContext"] = new DataContext()); 
    			} else {
    				return parentNode.dataContext;
    			}
    		} else {
    			return (DataContext)this["__dataContext"];
    		}
    	}
    	+{
    		DataContext old = (DataContext)this["__dataContext"];
    		if(old === value){ 
    			return;
    		}
    		
    		DataContext parentDc = parentNode.dataContext;
    		
    		this["__dataContext"] = value;
    		if(old != null && old.isRelative){
    			parentDc.removeDependent(old);
    		}
    		
    		if(value == null){
    			return;
    		}
    		
    		if(value.isRelative){
    			parentDc.addDependent(value);
        		if(parentDc.dataItem != null){
        			value.dataItem = parentDc.dataItem[value.property];
        		}
    		}
    	}
    }
}

public interface NodeList {
//	Node item(final /*unsigned */long index);
	public native Node this[long index];
	// readonly attribute /*unsigned */
	public native long length{}
}

public interface NamedNodeMap {
	public native Node getNamedItem(final String name);
	public native Node setNamedItem(final Node arg) throws DOMException;
	Node removeNamedItem(final String name) throws DOMException;
	public native Node item(final /*unsigned */long index);
	// readonly attribute /*unsigned */
	public native long length{}
	// Introduced final DOM Level 2:
	public native Node getNamedItemNS(final String namespaceURI, final String localName);
	// Introduced final DOM Level 2:
	public native Node setNamedItemNS(final Node arg) throws DOMException;
	// Introduced final DOM Level 2:
	public native Node removeNamedItemNS(final String namespaceURI, final String localName) throws DOMException;
}

public native interface CharacterData extends Node {
	//attribute 
	public native String data{}
   // throws DOMException on setting
  // throws DOMException on retrieval

	// readonly attribute /*unsigned */
	public native long length{}
	public native String substringData(final /*unsigned */long offset, final /*unsigned */long count) throws DOMException;
	public native void appendData(final String arg) throws DOMException;
	public native void insertData(final /*unsigned */long offset, final String arg) throws DOMException;
	public native void deleteData(final /*unsigned */long offset, final /*unsigned */long count)throws DOMException;
	public native void replaceData(final /*unsigned */long offset, final /*unsigned */long count, final String arg) throws DOMException;
}

public native interface Attr extends Node {
	// readonly attribute 
	public native String name{}
	// readonly attribute 
	public native boolean specified{}
	//attribute 
	public native String value{}
     // throws DOMException on setting

 // Introduced in DOM Level 2:
// readonly attribute 
	public Element ownerElement{}
}

public native interface Element extends Node {
	// readonly attribute 
	public native String tagName{}
	public native String getAttribute(final String name);
	public native void setAttribute(final String name, final String value) throws DOMException;
	public native void removeAttribute(final String name) throws DOMException;
	public native Attr getAttributeNode(final String name);
	public native Attr setAttributeNode(final Attr newAttr) throws DOMException;
	public native Attr removeAttributeNode(final Attr oldAttr) throws DOMException;
	public native NodeList getElementsByTagName(final String name);
	// Introduced final DOM Level 2:
	public native String getAttributeNS(final String namespaceURI, final String localName);
	// Introduced final DOM Level 2:
	public native void setAttributeNS(final String namespaceURI, final String qualifiedName, final String value) throws DOMException;
	// Introduced final DOM Level 2:
	public native void removeAttributeNS(final String namespaceURI,final String localName) throws DOMException;
	// Introduced final DOM Level 2:
	public native Attr getAttributeNodeNS(final String namespaceURI, final String localName);
	// Introduced final DOM Level 2:
	public native Attr setAttributeNodeNS(final Attr newAttr) throws DOMException;
	// Introduced final DOM Level 2:
	public native NodeList getElementsByTagNameNS(final String namespaceURI, final String localName);
	// Introduced in DOM Level 2:
	public native boolean hasAttribute(final String name);
	// Introduced final DOM Level 2:
	public native boolean hasAttributeNS(final String namespaceURI, final String localName);
}

public native interface Text extends CharacterData {
	Text splitText(final /*unsigned */long offset) throws DOMException;
}

public native interface Comment extends CharacterData {
}

public native interface CDATASection extends Text {
}

public interface DocumentType extends Node {
	// readonly attribute 
	public native String name{}
	// readonly attribute 
	public native NamedNodeMap entities{}
	// readonly attribute 
	public native NamedNodeMap notations{}
	// Introduced in DOM Level 2:
	// readonly attribute 
	public native String publicId{}
	// Introduced in DOM Level 2:
	// readonly attribute 
	public native String systemId{}
	// Introduced in DOM Level 2:
	// readonly attribute 
	public native String internalSubset{}
}

public native interface Notation extends Node {
	// readonly attribute 
	public native String publicId{}
	// readonly attribute 
	public native String systemId{}
}

public native interface Entity extends Node {
	// readonly attribute 
	public native String publicId{}
	// readonly attribute 
	public native String systemId{}
	// readonly attribute 
	public native String notationName{}
}

public native interface EntityReference extends Node {
}

public native interface ProcessingInstruction extends Node {
	// readonly attribute 
	public native String target{}
	//     attribute 
	public native String data{}
     // throws DOMException on setting

}

public native interface Document extends Node {
	// readonly attribute 
	public native DocumentType doctype{}
	// readonly attribute 
	public native DOMImplementation implementation{}
	// readonly attribute 
	public native Element documentElement{}
	public native Element createElement(final String tagName) throws DOMException;
	public native DocumentFragment createDocumentFragment();
	public native Text createTextNode(final String data);
	public native Comment createComment(final String data);
	public native CDATASection createCDATASection(final String data) throws DOMException;
	public native ProcessingInstruction createProcessingInstruction(final String target, final String data) throws DOMException;
	public native Attr createAttribute(final String name) throws DOMException;
	public native EntityReference  createEntityReference(final String name) throws DOMException;
	public native NodeList getElementsByTagName(final String tagname);
	// Introduced final DOM Level 2:
	public native Node importNode(final Node importedNode, final boolean deep) throws DOMException;
	// Introduced final DOM Level 2:
	public native Element createElementNS(final String namespaceURI, final String qualifiedName) throws DOMException;
	// Introduced final DOM Level 2:
	public native Attr createAttributeNS(final String namespaceURI, final String qualifiedName) throws DOMException;
	// Introduced final DOM Level 2:
	public native NodeList getElementsByTagNameNS(final String namespaceURI, final String localName);
	// Introduced final DOM Level 2:
	public native Element getElementById(final String elementId);
}

