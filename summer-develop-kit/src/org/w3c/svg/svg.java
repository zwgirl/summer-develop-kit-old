@Module
package org.w3c.svg;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.css.CSSRule;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSValue;
import org.w3c.dom.css.DocumentCSS;
import org.w3c.dom.css.RGBColor;
import org.w3c.dom.css.ViewCSS;
import org.w3c.event.DocumentEvent;
import org.w3c.event.Event;
import org.w3c.event.EventTarget;
import org.w3c.event.UIEvent;
import org.w3c.views.AbstractView;

//module svg {

public class SVGException extends Exception{
//  unsigned 
	public short code{}
	
	// SVGException code
//	const unsigned 
	static final short SVG_WRONG_TYPE_ERR = 0;
//	const unsigned 
	static final short SVG_INVALID_VALUE_ERR = 1;
//	const unsigned 
	static final short SVG_MATRIX_NOT_INVERTABLE = 2;
}

public interface SVGElement extends Element {
//	attribute 
	public String id{} //setthrows DOMException;
//	attribute 
	public String xmlbase{} //setthrows DOMException;
//	readonly attribute
	public SVGSVGElement ownerSVGElement{}
//	readonly attribute 
	public SVGElement viewportElement{}
}

public interface SVGAnimatedBoolean {
//           attribute
	public boolean baseVal{} // setthrows DOMException;
//  readonly attribute 
	public boolean animVal{}
}

public interface SVGAnimatedString {
//           attribute 
	public String baseVal{} // setthrows DOMException;
//  readonly attribute 
	public String animVal{}
}

public interface SVGStringList {

//  readonly attribute unsigned 
	public long numberOfItems{}

	void clear() throws DOMException;
	String initialize(final String newItem) throws DOMException;
	String getItem(final /*unsigned*/ long index) throws DOMException;
	String insertItemBefore(final String newItem, final /*unsigned*/ long index) throws DOMException;
	String replaceItem(final String newItem, final /*unsigned*/ long index) throws DOMException;
	String removeItem(final /*unsigned*/ long index) throws DOMException;
	String appendItem(final String newItem) throws DOMException;
}

public interface SVGAnimatedEnumeration {
//           attribute unsigned 
	public short baseVal{} // setthrows DOMException;
//  readonly attribute unsigned 
	public short animVal{}
}

public interface SVGAnimatedInteger {
//           attribute 
	public long baseVal{} // setthrows DOMException;
//  readonly attribute 
	public long animVal{}
}

public interface SVGNumber {
//  attribute 
	public float value{} // setthrows DOMException;
}

public interface SVGAnimatedNumber {
//           attribute
	public float baseVal{} // setthrows DOMException;
//  readonly attribute 
	public float animVal{}
}

public interface SVGNumberList {

//  readonly attribute unsigned 
	public long numberOfItems{}

	void clear() throws DOMException;
	SVGNumber initialize(final SVGNumber newItem) throws DOMException;
	SVGNumber getItem(final /*unsigned*/ long index) throws DOMException;
	SVGNumber insertItemBefore(final SVGNumber newItem, final /*unsigned*/ long index) throws DOMException;
	SVGNumber replaceItem(final SVGNumber newItem, final /*unsigned*/ long index) throws DOMException;
	SVGNumber removeItem(final /*unsigned*/ long index) throws DOMException;
	SVGNumber appendItem(final SVGNumber newItem) throws DOMException;
}

public interface SVGAnimatedNumberList {
//  readonly attribute 
	public SVGNumberList baseVal{}
//  readonly attribute 
	public SVGNumberList animVal{}
}

public interface SVGLength {

  // Length Unit Types
//  const unsigned 
	public static final short SVG_LENGTHTYPE_UNKNOWN = 0;
//  const unsigned 
	public static final short SVG_LENGTHTYPE_NUMBER = 1;
//  const unsigned
	public static final short SVG_LENGTHTYPE_PERCENTAGE = 2;
//  const unsigned 
	public static final short SVG_LENGTHTYPE_EMS = 3;
//  const unsigned 
	public static final short SVG_LENGTHTYPE_EXS = 4;
//  const unsigned 
	public static final short SVG_LENGTHTYPE_PX = 5;
//  const unsigned 
	public static final short SVG_LENGTHTYPE_CM = 6;
//  const unsigned 
	public static final short SVG_LENGTHTYPE_MM = 7;
//  const unsigned 
	public static final short SVG_LENGTHTYPE_IN = 8; 
//  const unsigned 
	public static final short SVG_LENGTHTYPE_PT = 9;
//  const unsigned 
	public static final short SVG_LENGTHTYPE_PC = 10;

//  readonly attribute unsigned 
	public static final short unitType{}
//           attribute 
	public static final float value{} // setthrows DOMException;
//           attribute
	public static final float valueInSpecifiedUnits{} // setthrows DOMException;
//           attribute 
	public static final String valueAsString{} // setthrows DOMException;

	void newValueSpecifiedUnits(final /*unsigned*/ short unitType, final float valueInSpecifiedUnits) throws DOMException;
	void convertToSpecifiedUnits(final /*unsigned*/ short unitType) throws DOMException;
}

public interface SVGAnimatedLength {
//  readonly attribute 
	public SVGLength baseVal{}
//  readonly attribute 
	public SVGLength animVal{}
}

public interface SVGLengthList {

//  readonly attribute unsigned 
	public long numberOfItems{}

	void clear() throws DOMException;
	SVGLength initialize(final SVGLength newItem) throws DOMException;
	SVGLength getItem(final /*unsigned*/ long index) throws DOMException;
	SVGLength insertItemBefore(final SVGLength newItem, final /*unsigned*/ long index) throws DOMException;
	SVGLength replaceItem(final SVGLength newItem, final /*unsigned*/ long index) throws DOMException;
	SVGLength removeItem(final /*unsigned*/ long index) throws DOMException;
	SVGLength appendItem(final SVGLength newItem) throws DOMException;
}

public interface SVGAnimatedLengthList {
//  readonly attribute /
  public SVGLengthList baseVal{}
//  readonly attribute
  public SVGLengthList animVal{}
}

public interface SVGAngle {

  // Angle Unit Types
//  const unsigned 
	public static final short SVG_ANGLETYPE_UNKNOWN = 0;
//  const unsigned 
	public static final short SVG_ANGLETYPE_UNSPECIFIED = 1;
//  const unsigned 
	public static final short SVG_ANGLETYPE_DEG = 2;
//  const unsigned 
	public static final short SVG_ANGLETYPE_RAD = 3;
//  const unsigned 
	public static final short SVG_ANGLETYPE_GRAD = 4;

//  readonly attribute unsigned 
	public short unitType{}
//           attribute 
	public float value{} // setthrows DOMException;
//           attribute 
	public float valueInSpecifiedUnits{} // setthrows DOMException;
//           attribute 
	public String valueAsString{} // setthrows DOMException;

	void newValueSpecifiedUnits(final /*unsigned*/ short unitType, final float valueInSpecifiedUnits) throws DOMException;
	void convertToSpecifiedUnits(final /*unsigned*/ short unitType) throws DOMException;
}

public interface SVGAnimatedAngle {
//  readonly attribute 
	public SVGAngle baseVal{}
//  readonly attribute 
	public SVGAngle animVal{}
}

public interface SVGColor extends CSSValue {

  // Color Types
//  const unsigned 
	public static final short SVG_COLORTYPE_UNKNOWN = 0;
//  const unsigned 
	public static final short SVG_COLORTYPE_RGBCOLOR = 1;
//  const unsigned 
	public static final short SVG_COLORTYPE_RGBCOLOR_ICCCOLOR = 2;
//  const unsigned 
	public static final short SVG_COLORTYPE_CURRENTCOLOR = 3;

//  readonly attribute unsigned 
	public short colorType{}
//  readonly attribute 
	public RGBColor rgbColor{}
//  readonly attribute 
	public SVGICCColor iccColor{}

	void setRGBColor(final String rgbColor) throws SVGException;
	void setRGBColorICCColor(final String rgbColor, final String iccColor) throws SVGException;
	void setColor(final /*unsigned*/ short colorType, final String rgbColor, final String iccColor) throws SVGException;
}

public interface SVGICCColor {
//           attribute 
	public String colorProfile{} // setthrows DOMException;
//  readonly attribute 
	public SVGNumberList colors{}
}

public interface SVGRect {
//  attribute 
	public float x{} // setthrows DOMException;
//  attribute 
	public float y{} // setthrows DOMException;
//  attribute 
	public float width{} // setthrows DOMException;
//  attribute 
	public float height{} // setthrows DOMException;
}

public interface SVGAnimatedRect {
//  readonly attribute 
	public SVGRect baseVal{}
//  readonly attribute 
	public SVGRect animVal{}
}

public interface SVGUnitTypes {
  // Unit Types
//  const unsigned 
	public static final short SVG_UNIT_TYPE_UNKNOWN = 0;
//  const unsigned 
	public static final short SVG_UNIT_TYPE_USERSPACEONUSE = 1;
//  const unsigned 
	public static final short SVG_UNIT_TYPE_OBJECTBOUNDINGBOX = 2;
}

public interface SVGStylable {

//  readonly attribute 
	public SVGAnimatedString className{}
//  readonly attribute 
	public CSSStyleDeclaration style{}

	CSSValue getPresentationAttribute(final String name);
}

public interface SVGLocatable {

//  readonly attribute 
	public SVGElement nearestViewportElement{}
//  readonly attribute 
	public SVGElement farthestViewportElement{}

	SVGRect getBBox();
	SVGMatrix getCTM();
	SVGMatrix getScreenCTM();
 	SVGMatrix getTransformToElement(final SVGElement element) throws SVGException;
}

public interface SVGTransformable extends SVGLocatable {
//  readonly attribute 
	public SVGAnimatedTransformList transform{}
}

public interface SVGTests {

//  readonly attribute 
	public SVGStringList requiredFeatures{}
//  readonly attribute 
	public SVGStringList requiredExtensions{}
//  readonly attribute 
	public SVGStringList systemLanguage{}

	boolean hasExtension(final String extension);
}

public interface SVGLangSpace {
//  attribute
	public String xmllang{} // setthrows DOMException;
//  attribute 
	public String xmlspace{} // setthrows DOMException;
}

public interface SVGExternalResourcesRequired {
//  readonly attribute 
	public SVGAnimatedBoolean externalResourcesRequired{}
}

public interface SVGFitToViewBox {
//  readonly attribute 
	public SVGAnimatedRect viewBox{}
//  readonly attribute 
	public SVGAnimatedPreserveAspectRatio preserveAspectRatio{}
}

public interface SVGZoomAndPan {

  // Zoom and Pan Types
//  const unsigned 
	public static final short SVG_ZOOMANDPAN_UNKNOWN = 0;
//  const unsigned 
	public static final short SVG_ZOOMANDPAN_DISABLE = 1;
//  const unsigned 
	public static final short SVG_ZOOMANDPAN_MAGNIFY = 2;

//  attribute unsigned 
	public short zoomAndPan{} //setthrows DOMException;
}

public interface SVGViewSpec extends SVGZoomAndPan,
                        SVGFitToViewBox {
//  readonly attribute 
	public SVGTransformList transform{}
//  readonly attribute 
	public SVGElement viewTarget{}
//  readonly attribute 
	public String viewBoxString{}
//  readonly attribute 
	public String preserveAspectRatioString{}
//  readonly attribute 
	public String transformString{}
//  readonly attribute 
	public String viewTargetString{}
}

public interface SVGURIReference {
//  readonly attribute 
	public SVGAnimatedString href{}
}

public interface SVGCSSRule extends CSSRule {
//  const unsigned 
	public static final short COLOR_PROFILE_RULE = 7;
}

public interface SVGRenderingIntent {
  // Rendering Intent Types
//  const unsigned 
	public static final short RENDERING_INTENT_UNKNOWN = 0;
//  const unsigned 
	public static final short RENDERING_INTENT_AUTO = 1;
//  const unsigned 
	public static final short RENDERING_INTENT_PERCEPTUAL = 2;
//  const unsigned
	public static final short RENDERING_INTENT_RELATIVE_COLORIMETRIC = 3;
//  const unsigned 
	public static final short RENDERING_INTENT_SATURATION = 4;
//  const unsigned 
	public static final short RENDERING_INTENT_ABSOLUTE_COLORIMETRIC = 5;
}

public interface SVGDocument extends Document,
                        DocumentEvent {
//  readonly attribute 
	public String title{}
//  readonly attribute 
	public String referrer{}
//  readonly attribute 
	public String domain{}
//  readonly attribute 
	public String URL{}
//  readonly attribute 
	public SVGSVGElement rootElement{}
}

public interface SVGSVGElement extends SVGElement,
                          SVGTests,
                          SVGLangSpace,
                          SVGExternalResourcesRequired,
                          SVGStylable,
                          SVGLocatable,
                          SVGFitToViewBox,
                          SVGZoomAndPan,
                          DocumentEvent,
                          ViewCSS,
                          DocumentCSS {

//  readonly attribute 
	public SVGAnimatedLength x{}
//  readonly attribute 
	public SVGAnimatedLength y{}
//  readonly attribute 
	public SVGAnimatedLength width{}
//  readonly attribute
	public SVGAnimatedLength height{}
//           attribute
	public String contentScriptType{} // setthrows DOMException;
//           attribute 
	public String contentStyleType{} // setthrows DOMException;
//  readonly attribute 
	public SVGRect viewport{}
//  readonly attribute 
	public float pixelUnitToMillimeterX{}
//  readonly attribute 
	public float pixelUnitToMillimeterY{}
//  readonly attribute 
	public float screenPixelToMillimeterX{}
//  readonly attribute 
	public float screenPixelToMillimeterY{}
//  readonly attribute 
	public boolean useCurrentView{}
//  readonly attribute 
	public SVGViewSpec currentView{}
//           attribute
	public float currentScale{}
//  readonly attribute 
	public SVGPoint currentTranslate{}

  /*unsigned*/ long suspendRedraw(final /*unsigned*/ long maxWaitMilliseconds);
  	void unsuspendRedraw(final /*unsigned*/ long suspendHandleID);
  	void unsuspendRedrawAll();
  	void forceRedraw();
  	void pauseAnimations();
  	void unpauseAnimations();
  	boolean animationsPaused();
  	float getCurrentTime();
  	void setCurrentTime(final float seconds);
  	NodeList getIntersectionList(final SVGRect rect, final SVGElement referenceElement);
  	NodeList getEnclosureList(final SVGRect rect, final SVGElement referenceElement);
  	boolean checkIntersection(final SVGElement element, final SVGRect rect);
  	boolean checkEnclosure(final SVGElement element, final SVGRect rect);
  	void deselectAll();
  	SVGNumber createSVGNumber();
  	SVGLength createSVGLength();
  	SVGAngle createSVGAngle();
	  SVGPoint createSVGPoint();
	  SVGMatrix createSVGMatrix();
	  SVGRect createSVGRect();
	  SVGTransform createSVGTransform();
	  SVGTransform createSVGTransformFromMatrix(final SVGMatrix matrix);
	  Element getElementById(final String elementId);
}

public interface SVGGElement extends SVGElement,
                        SVGTests,
                        SVGLangSpace,
                        SVGExternalResourcesRequired,
                        SVGStylable,
                        SVGTransformable {
}

public interface SVGDefsElement extends SVGElement,
                           SVGTests,
                           SVGLangSpace,
                           SVGExternalResourcesRequired,
                           SVGStylable,
                           SVGTransformable {
}

public interface SVGDescElement extends SVGElement,
                           SVGLangSpace,
                          SVGStylable {
}

public interface SVGTitleElement extends SVGElement,
                            SVGLangSpace,
                            SVGStylable {
}

public interface SVGSymbolElement extends SVGElement,
                             SVGLangSpace,
                             SVGExternalResourcesRequired,
                             SVGStylable,
                             SVGFitToViewBox {
}

public interface SVGUseElement extends SVGElement,
                          SVGURIReference,
                          SVGTests,
                          SVGLangSpace,
                          SVGExternalResourcesRequired,
                          SVGStylable,
                          SVGTransformable {
//  readonly attribute 
	public SVGAnimatedLength x{}
//  readonly attribute 
	public SVGAnimatedLength y{}
//  readonly attribute 
	public SVGAnimatedLength width{}
//  readonly attribute 
	public SVGAnimatedLength height{}
//  readonly attribute 
	public SVGElementInstance instanceRoot{}
//  readonly attribute 
	public SVGElementInstance animatedInstanceRoot{}
}

public interface SVGElementInstance extends EventTarget {
//  readonly attribute 
	public SVGElement correspondingElement{}
//  readonly attribute 
	public SVGUseElement correspondingUseElement{}
//  readonly attribute 
	public SVGElementInstance parentNode{}
//  readonly attribute 
	public SVGElementInstanceList childNodes{}
//  readonly attribute 
	public SVGElementInstance firstChild{}
//  readonly attribute 
	public SVGElementInstance lastChild{}
//  readonly attribute 
	public SVGElementInstance previousSibling{}
//  readonly attribute 
	public SVGElementInstance nextSibling{}
}

public interface SVGElementInstanceList {

//  readonly attribute unsigned 
	public long length{}

	SVGElementInstance item(final /*unsigned*/ long index);
}

public interface SVGImageElement extends SVGElement,
                            SVGURIReference,
                            SVGTests,
                            SVGLangSpace,
                            SVGExternalResourcesRequired,
                            SVGStylable,
                            SVGTransformable {
//  readonly attribute 
	public SVGAnimatedLength x{}
//  readonly attribute
	public SVGAnimatedLength y{}
//  readonly attribute
	public SVGAnimatedLength width{}
//  readonly attribute 
	public SVGAnimatedLength height{}
//  readonly attribute 
  public SVGAnimatedPreserveAspectRatio preserveAspectRatio{}
}

public interface SVGSwitchElement extends SVGElement,
                             SVGTests,
                             SVGLangSpace,
                             SVGExternalResourcesRequired,
                             SVGStylable,
                             SVGTransformable {
}

public interface GetSVGDocument {
  SVGDocument getSVGDocument();
}

public interface SVGStyleElement extends SVGElement,
                            SVGLangSpace {
//  attribute 
	public String type{} // setthrows DOMException;
//  attribute 
	public String media{} // setthrows DOMException;
//  attribute 
	public String title{} // setthrows DOMException;
}

public interface SVGPoint {

//  attribute 
	public float x{} // setthrows DOMException;
//  attribute 
	public float y{} //setthrows DOMException;

	SVGPoint matrixTransform(final SVGMatrix matrix);
}

public interface SVGPointList {

//  readonly attribute unsigned 
	public long numberOfItems{}

	void clear() throws DOMException;
	SVGPoint initialize(final SVGPoint newItem) throws DOMException;
	SVGPoint getItem(final /*unsigned*/ long index) throws DOMException;
	SVGPoint insertItemBefore(final SVGPoint newItem, final /*unsigned*/ long index) throws DOMException;
	SVGPoint replaceItem(final SVGPoint newItem, final /*unsigned*/ long index) throws DOMException;
	SVGPoint removeItem(final /*unsigned*/ long index) throws DOMException;
	SVGPoint appendItem(final SVGPoint newItem) throws DOMException;
}

public interface SVGMatrix {

//  attribute 
	public float a{} // setthrows DOMException;
//  attribute
	public float b{} // setthrows DOMException;
//  attribute 
	public float c{} // setthrows DOMException;
//  attribute
	public float d{} // setthrows DOMException;
//  attribute
	public float e{} // setthrows DOMException;
//  attribute
	public float f{} // setthrows DOMException;

	SVGMatrix multiply(final SVGMatrix secondMatrix);
	SVGMatrix inverse() throws SVGException;
	SVGMatrix translate(final float x, final float y);
	SVGMatrix scale(final float scaleFactor);
	SVGMatrix scaleNonUniform(final float scaleFactorX, final float scaleFactorY);
	SVGMatrix rotate(final float angle);
	SVGMatrix rotateFromVector(final float x, final float y) throws SVGException;
	SVGMatrix flipX();
	SVGMatrix flipY();
	SVGMatrix skewX(final float angle);
	SVGMatrix skewY(final float angle);
}

public interface SVGTransform {

  // Transform Types
//  const unsigned
	public final static short SVG_TRANSFORM_UNKNOWN = 0;
//  const unsigned 
	public final static short SVG_TRANSFORM_MATRIX = 1;
//  const unsigned 
	public final static short SVG_TRANSFORM_TRANSLATE = 2;
//  const unsigned 
	public final static short SVG_TRANSFORM_SCALE = 3;
//  const unsigned 
	public final static short SVG_TRANSFORM_ROTATE = 4;
//  const unsigned 
	public final static short SVG_TRANSFORM_SKEWX = 5;
//  const unsigned 
	public final static short SVG_TRANSFORM_SKEWY = 6;

//	readonly attribute unsigned 
	public short type{}
//	readonly attribute 
	public SVGMatrix matrix{}
//	readonly attribute 
	public float angle{}

	void setMatrix(final SVGMatrix matrix) throws DOMException;
	void setTranslate(final float tx, final float ty) throws DOMException;
	void setScale(final float sx, final float sy) throws DOMException;
	void setRotate(final float angle, final float cx, final float cy) throws DOMException;
	void setSkewX(final float angle) throws DOMException;
	void setSkewY(final float angle) throws DOMException;
}

public interface SVGTransformList {

//  readonly attribute unsigned 
	public long numberOfItems{}

	void clear() throws DOMException;
	SVGTransform initialize(final SVGTransform newItem) throws DOMException;
	SVGTransform getItem(final /*unsigned*/ long index) throws DOMException;
	SVGTransform insertItemBefore(final SVGTransform newItem, final /*unsigned*/ long index) throws DOMException;
	SVGTransform replaceItem(final SVGTransform newItem, final /*unsigned*/ long index) throws DOMException;
	SVGTransform removeItem(final /*unsigned*/ long index) throws DOMException;
	SVGTransform appendItem(final SVGTransform newItem) throws DOMException;
	SVGTransform createSVGTransformFromMatrix(final SVGMatrix matrix);
	SVGTransform consolidate() throws DOMException;
}

public interface SVGAnimatedTransformList {
//  readonly attribute 
	public SVGTransformList baseVal{}
//  readonly attribute 
	public SVGTransformList animVal{}
}

public interface SVGPreserveAspectRatio {

  // Alignment Types
//  const unsigned 
	public static final short SVG_PRESERVEASPECTRATIO_UNKNOWN = 0;
//  const unsigned 
	public static final short SVG_PRESERVEASPECTRATIO_NONE = 1;
//  const unsigned 
	public static final short SVG_PRESERVEASPECTRATIO_XMINYMIN = 2;
//  const unsigned 
	public static final short SVG_PRESERVEASPECTRATIO_XMIDYMIN = 3;
//  const unsigned 
	public static final short SVG_PRESERVEASPECTRATIO_XMAXYMIN = 4;
//  const unsigned 
	public static final short SVG_PRESERVEASPECTRATIO_XMINYMID = 5;
//  const unsigned 
	public static final short SVG_PRESERVEASPECTRATIO_XMIDYMID = 6;
//  const unsigned 
	public static final short SVG_PRESERVEASPECTRATIO_XMAXYMID = 7;
//  const unsigned 
	public static final short SVG_PRESERVEASPECTRATIO_XMINYMAX = 8;
//  const unsigned 
	public static final short SVG_PRESERVEASPECTRATIO_XMIDYMAX = 9;
//  const unsigned 
	public static final short SVG_PRESERVEASPECTRATIO_XMAXYMAX = 10;

  // Meet-or-slice Types
//  const unsigned 
	public static final short SVG_MEETORSLICE_UNKNOWN = 0;
//  const unsigned public static final 
	short SVG_MEETORSLICE_MEET = 1;
//  const unsigned 
	public static final short SVG_MEETORSLICE_SLICE = 2;

//  attribute unsigned 
	public short align{} // setthrows DOMException;
//  attribute unsigned 
	public short meetOrSlice{} // setthrows DOMException;
}

public interface SVGAnimatedPreserveAspectRatio {
//  readonly attribute 
	public SVGPreserveAspectRatio baseVal{}
//  readonly attribute 
	public SVGPreserveAspectRatio animVal{}
}

public interface SVGPathSeg {

  // Path Segment Types
//  const unsigned 
	public static final short PATHSEG_UNKNOWN = 0;
//  const unsigned 
	public static final short PATHSEG_CLOSEPATH = 1;
//  const unsigned 
	public static final short PATHSEG_MOVETO_ABS = 2;
//  const unsigned 
	public static final short PATHSEG_MOVETO_REL = 3;
//  const unsigned 
	public static final short PATHSEG_LINETO_ABS = 4;
//  const unsigned 
	public static final short PATHSEG_LINETO_REL = 5;
//  const unsigned 
	public static final short PATHSEG_CURVETO_CUBIC_ABS = 6;
//  const unsigned 
	public static final short PATHSEG_CURVETO_CUBIC_REL = 7;
//  const unsigned 
	public static final short PATHSEG_CURVETO_QUADRATIC_ABS = 8;
//  const unsigned 
	public static final short PATHSEG_CURVETO_QUADRATIC_REL = 9;
//  const unsigned 
	public static final short PATHSEG_ARC_ABS = 10;
//  const unsigned 
	public static final short PATHSEG_ARC_REL = 11;
//  const unsigned 
	public static final short PATHSEG_LINETO_HORIZONTAL_ABS = 12;
//  const unsigned 
	public static final short PATHSEG_LINETO_HORIZONTAL_REL = 13;
//  const unsigned 
	public static final short PATHSEG_LINETO_VERTICAL_ABS = 14;
//  const unsigned
	public static final short PATHSEG_LINETO_VERTICAL_REL = 15;
//  const unsigned 
	public static final short PATHSEG_CURVETO_CUBIC_SMOOTH_ABS = 16;
//  const unsigned
	public static final short PATHSEG_CURVETO_CUBIC_SMOOTH_REL = 17;
//  const unsigned 
	public static final short PATHSEG_CURVETO_QUADRATIC_SMOOTH_ABS = 18;
//  const unsigned 
	public static final short PATHSEG_CURVETO_QUADRATIC_SMOOTH_REL = 19;

//  readonly attribute unsigned
	public short pathSegType{}
//  readonly attribute 
	public String pathSegTypeAsLetter{}
}

public interface SVGPathSegClosePath extends SVGPathSeg {
}

public interface SVGPathSegMovetoAbs extends SVGPathSeg {
//  attribute 
	public float x{} //setthrows DOMException;
//  attribute 
	public float y{} //setthrows DOMException;
}

public interface SVGPathSegMovetoRel extends SVGPathSeg {
//  attribute 
	public float x{} //setthrows DOMException;
//  attribute 
	public float y{} //setthrows DOMException;
}

public interface SVGPathSegLinetoAbs extends SVGPathSeg {
//  attribute 
	public float x{} //setthrows DOMException;
//  attribute 
	public float y{} //setthrows DOMException;
}

public interface SVGPathSegLinetoRel extends SVGPathSeg {
//  attribute
	public float x{} //setthrows DOMException;
//  attribute
	public float y{} //setthrows DOMException;
}

public interface SVGPathSegCurvetoCubicAbs extends SVGPathSeg {
//  attribute 
	public float x{} //setthrows DOMException;
//  attribute 
	public float y{} //setthrows DOMException;
//  attribute
	public float x1{} //setthrows DOMException;
//  attribute
	public float y1{} //setthrows DOMException;
//  attribute
	public float x2{} //setthrows DOMException;
//  attribute
	public float y2{} //setthrows DOMException;
}

public interface SVGPathSegCurvetoCubicRel extends SVGPathSeg {
//  attribute
	public float x{} // setthrows DOMException;
//  attribute
	public float y{} // setthrows DOMException;
//  attribute
	public float x1{} // setthrows DOMException;
//  attribute
	public float y1{} // setthrows DOMException;
//  attribute
	public float x2{} // setthrows DOMException;
//  attribute
	public float y2{} // setthrows DOMException;
}

public interface SVGPathSegCurvetoQuadraticAbs extends SVGPathSeg {
//  attribute
	public float x{} // setthrows DOMException;
//  attribute
	public float y{} // setthrows DOMException;
//  attribute
	public float x1{} // setthrows DOMException;
//  attribute
	public float y1{} // setthrows DOMException;
}

public interface SVGPathSegCurvetoQuadraticRel extends SVGPathSeg {
//  attribute
	public float x{} // setthrows DOMException;
//  attribute
	public float y{} // setthrows DOMException;
//  attribute
	public float x1{} // setthrows DOMException;
//  attribute
	public float y1{} // setthrows DOMException;
}

public interface SVGPathSegArcAbs extends SVGPathSeg {
//  attribute
	public float x{} // setthrows DOMException;
//  attribute
	public float y{} // setthrows DOMException;
//  attribute
	public float r1{} // setthrows DOMException;
//  attribute
	public float r2{} // setthrows DOMException;
//  attribute
	public float angle{} // setthrows DOMException;
//  attribute
	public boolean largeArcFlag{} // setthrows DOMException;
//  attribute
	public boolean sweepFlag{} // setthrows DOMException;
}

public interface SVGPathSegArcRel extends SVGPathSeg {
//  attribute 
	public float x{} // setthrows DOMException;
//  attribute
	public float y{} // setthrows DOMException;
//  attribute
	public float r1{} // setthrows DOMException;
//  attribute
	public float r2{} // setthrows DOMException;
//  attribute
	public float angle{} // setthrows DOMException;
//  attribute
	public boolean largeArcFlag{} // setthrows DOMException;
//  attribute
	public boolean sweepFlag{} // setthrows DOMException;
}

public interface SVGPathSegLinetoHorizontalAbs extends SVGPathSeg {
//  attribute
	public float x{} // setthrows DOMException;
}

public interface SVGPathSegLinetoHorizontalRel extends SVGPathSeg {
//  attribute
	public float x{} // setthrows DOMException;
}

public interface SVGPathSegLinetoVerticalAbs extends SVGPathSeg {
//  attribute
	public float y{} // setthrows DOMException;
}

public interface SVGPathSegLinetoVerticalRel extends SVGPathSeg {
//  attribute
	public float y{} // setthrows DOMException;
}

public interface SVGPathSegCurvetoCubicSmoothAbs extends SVGPathSeg {
//  attribute
	public float x{} // setthrows DOMException;
//  attribute
	public float y{} // setthrows DOMException;
//  attribute
	public float x2{} // setthrows DOMException;
//  attribute
	public float y2{} // setthrows DOMException;
}

public interface SVGPathSegCurvetoCubicSmoothRel extends SVGPathSeg {
//  attribute
	public float x{} // setthrows DOMException;
//  attribute
	public float y{} // setthrows DOMException;
//  attribute
	public float x2{} // setthrows DOMException;
//  attribute
	public float y2{} // setthrows DOMException;
}

public interface SVGPathSegCurvetoQuadraticSmoothAbs extends SVGPathSeg {
//  attribute 
	public float x{} // setthrows DOMException;
//  attribute
	public float y{} // setthrows DOMException;
}

public interface SVGPathSegCurvetoQuadraticSmoothRel extends SVGPathSeg {
//  attribute
	public float x{} // setthrows DOMException;
//  attribute
	public float y{} // setthrows DOMException;
}

public interface SVGPathSegList {

//  readonly attribute unsigned 
	public long numberOfItems{}

	void clear() throws DOMException;
	SVGPathSeg initialize(final SVGPathSeg newItem) throws DOMException;
	SVGPathSeg getItem(final /*unsigned*/ long index) throws DOMException;
	SVGPathSeg insertItemBefore(final SVGPathSeg newItem, final /*unsigned*/ long index) throws DOMException;
	SVGPathSeg replaceItem(final SVGPathSeg newItem, final /*unsigned*/ long index) throws DOMException;
	SVGPathSeg removeItem(final /*unsigned*/ long index) throws DOMException;
	SVGPathSeg appendItem(final SVGPathSeg newItem) throws DOMException;
}

public interface SVGAnimatedPathData {
//  readonly attribute 
	public SVGPathSegList pathSegList{}
//  readonly attribute 
	public SVGPathSegList normalizedPathSegList{}
//  readonly attribute 
	public SVGPathSegList animatedPathSegList{}
//  readonly attribute 
	public SVGPathSegList animatedNormalizedPathSegList{}
}

public interface SVGPathElement extends SVGElement,
                           SVGTests,
                           SVGLangSpace,
                           SVGExternalResourcesRequired,
                           SVGStylable,
                           SVGTransformable,
                           SVGAnimatedPathData {

//  readonly attribute 
	public SVGAnimatedNumber pathLength{}

  float getTotalLength();
  SVGPoint getPointAtLength(final float distance);
  /*unsigned*/ long getPathSegAtLength(final float distance);
  SVGPathSegClosePath createSVGPathSegClosePath();
  SVGPathSegMovetoAbs createSVGPathSegMovetoAbs(final float x, final float y);
  SVGPathSegMovetoRel createSVGPathSegMovetoRel(final float x, final float y);
  SVGPathSegLinetoAbs createSVGPathSegLinetoAbs(final float x, final float y);
  SVGPathSegLinetoRel createSVGPathSegLinetoRel(final float x, final float y);
  SVGPathSegCurvetoCubicAbs createSVGPathSegCurvetoCubicAbs(final float x, final float y, final float x1, final float y1, final float x2, final float y2);
  SVGPathSegCurvetoCubicRel createSVGPathSegCurvetoCubicRel(final float x, final float y, final float x1, final float y1, final float x2, final float y2);
  SVGPathSegCurvetoQuadraticAbs createSVGPathSegCurvetoQuadraticAbs(final float x, final float y, final float x1, final float y1);
  SVGPathSegCurvetoQuadraticRel createSVGPathSegCurvetoQuadraticRel(final float x, final float y, final float x1, final float y1);
  SVGPathSegArcAbs createSVGPathSegArcAbs(final float x, final float y, final float r1, final float r2, final float angle, final boolean largeArcFlag, final boolean sweepFlag);
  SVGPathSegArcRel createSVGPathSegArcRel(final float x, final float y, final float r1, final float r2, final float angle, final boolean largeArcFlag, final boolean sweepFlag);
  SVGPathSegLinetoHorizontalAbs createSVGPathSegLinetoHorizontalAbs(final float x);
  SVGPathSegLinetoHorizontalRel createSVGPathSegLinetoHorizontalRel(final float x);
  SVGPathSegLinetoVerticalAbs createSVGPathSegLinetoVerticalAbs(final float y);
  SVGPathSegLinetoVerticalRel createSVGPathSegLinetoVerticalRel(final float y);
  SVGPathSegCurvetoCubicSmoothAbs createSVGPathSegCurvetoCubicSmoothAbs(final float x, final float y, final float x2, final float y2);
  SVGPathSegCurvetoCubicSmoothRel createSVGPathSegCurvetoCubicSmoothRel(final float x, final float y, final float x2, final float y2);
  SVGPathSegCurvetoQuadraticSmoothAbs createSVGPathSegCurvetoQuadraticSmoothAbs(final float x, final float y);
  SVGPathSegCurvetoQuadraticSmoothRel createSVGPathSegCurvetoQuadraticSmoothRel(final float x, final float y);
}

public interface SVGRectElement extends SVGElement,
                           SVGTests,
                           SVGLangSpace,
                           SVGExternalResourcesRequired,
                           SVGStylable,
                           SVGTransformable {
//  readonly attribute 
	public SVGAnimatedLength x{}
//  readonly attribute 
	public SVGAnimatedLength y{}
//  readonly attribute 
	public SVGAnimatedLength width{}
//  readonly attribute 
	public SVGAnimatedLength height{}
//  readonly attribute 
	public SVGAnimatedLength rx{}
//  readonly attribute 
	public SVGAnimatedLength ry{}
}

public interface SVGCircleElement extends SVGElement,
                             SVGTests,
                             SVGLangSpace,
                             SVGExternalResourcesRequired,
                             SVGStylable,
                             SVGTransformable {
//  readonly attribute 
	public SVGAnimatedLength cx{}
//  readonly attribute 
	public SVGAnimatedLength cy{}
//  readonly attribute 
	public SVGAnimatedLength r{}
}

public interface SVGEllipseElement extends SVGElement,
                              SVGTests,
                              SVGLangSpace,
                              SVGExternalResourcesRequired,
                              SVGStylable,
                              SVGTransformable {
//  readonly attribute 
	public SVGAnimatedLength cx{}
//  readonly attribute 
	public SVGAnimatedLength cy{}
//  readonly attribute 
	public SVGAnimatedLength rx{}
//  readonly attribute 
	public SVGAnimatedLength ry{}
}

public interface SVGLineElement extends SVGElement,
                           SVGTests,
                           SVGLangSpace,
                           SVGExternalResourcesRequired,
                           SVGStylable,
                           SVGTransformable {
//  readonly attribute
	public SVGAnimatedLength x1{}
//  readonly attribute 
	public SVGAnimatedLength y1{}
//  readonly attribute
	public SVGAnimatedLength x2{}
//  readonly attribute 
	public SVGAnimatedLength y2{}
}

public interface SVGAnimatedPoints {
//  readonly attribute 
	public SVGPointList points{}
//  readonly attribute 
	public SVGPointList animatedPoints{}
}

public interface SVGPolylineElement extends SVGElement,
                               SVGTests,
                               SVGLangSpace,
                               SVGExternalResourcesRequired,
                               SVGStylable,
                               SVGTransformable,
                               SVGAnimatedPoints {
}

public interface SVGPolygonElement extends SVGElement,
                              SVGTests,
                              SVGLangSpace,
                              SVGExternalResourcesRequired,
                              SVGStylable,
                              SVGTransformable,
                              SVGAnimatedPoints {
}

public interface SVGTextContentElement extends SVGElement,
                                  SVGTests,
                                  SVGLangSpace,
                                  SVGExternalResourcesRequired,
                                  SVGStylable {

  // lengthAdjust Types
//  const unsigned 
	public static final short LENGTHADJUST_UNKNOWN = 0;
//  const unsigned 
	public static final short LENGTHADJUST_SPACING = 1;
//  const unsigned 
	public static final short LENGTHADJUST_SPACINGANDGLYPHS = 2;

//  readonly attribute 
	public SVGAnimatedLength textLength{}
//  readonly attribute 
	public SVGAnimatedEnumeration lengthAdjust{}

	long getNumberOfChars();
	float getComputedTextLength();
	float getSubStringLength(final /*unsigned*/ long charnum, final /*unsigned*/ long nchars) throws DOMException;
	SVGPoint getStartPositionOfChar(final /*unsigned*/ long charnum) throws DOMException;
	SVGPoint getEndPositionOfChar(final /*unsigned*/ long charnum) throws DOMException;
	SVGRect getExtentOfChar(final /*unsigned*/ long charnum) throws DOMException;
	float getRotationOfChar(final /*unsigned*/ long charnum) throws DOMException;
	long getCharNumAtPosition(final SVGPoint point);
	void selectSubString(final /*unsigned*/ long charnum, final /*unsigned*/ long nchars) throws DOMException;
}

public interface SVGTextPositioningElement extends SVGTextContentElement {
//  readonly attribute 
	public SVGAnimatedLengthList x{}
//  readonly attribute 
	public SVGAnimatedLengthList y{}
//  readonly attribute 
	public SVGAnimatedLengthList dx{}
//  readonly attribute 
	public SVGAnimatedLengthList dy{}
//  readonly attribute 
	public SVGAnimatedNumberList rotate{}
}

public interface SVGTextElement extends SVGTextPositioningElement,
                           SVGTransformable {
}

public interface SVGTSpanElement extends SVGTextPositioningElement {
}

public interface SVGTRefElement extends SVGTextPositioningElement,
                           SVGURIReference {
}

public interface SVGTextPathElement extends SVGTextContentElement,
                               SVGURIReference {

  // textPath Method Types
//  const unsigned short 
	public static final short TEXTPATH_METHODTYPE_UNKNOWN = 0;
//  const unsigned 
	public static final short TEXTPATH_METHODTYPE_ALIGN = 1;
//  const unsigned
	public static final short TEXTPATH_METHODTYPE_STRETCH = 2;

  // textPath Spacing Types
//  const unsigned
	public static final short TEXTPATH_SPACINGTYPE_UNKNOWN = 0;
//  const unsigned
	public static final short TEXTPATH_SPACINGTYPE_AUTO = 1;
//  const unsigned 
	public static final short TEXTPATH_SPACINGTYPE_EXACT = 2;

//  readonly attribute 
	public SVGAnimatedLength startOffset{}
//  readonly attribute
	public SVGAnimatedEnumeration method{}
//  readonly attribute 
	public SVGAnimatedEnumeration spacing{}
}

public interface SVGAltGlyphElement extends SVGTextPositioningElement,
                               SVGURIReference {
//  attribute 
	public String glyphRef{} // setthrows DOMException;
//  attribute 
	public String format{} // setthrows DOMException;
}

public interface SVGAltGlyphDefElement extends SVGElement {
}

public interface SVGAltGlyphItemElement extends SVGElement {
}

public interface SVGGlyphRefElement extends SVGElement,
                               SVGURIReference,
                               SVGStylable {
//  attribute 
	public String glyphRef{} // setthrows DOMException;
//  attribute 
	public String format{} // setthrows DOMException;
//  attribute
	public float x{} // setthrows DOMException;
//  attribute 
	public float y{} // setthrows DOMException;
//  attribute
	public float dx{} // setthrows DOMException;
//  attribute
	public float dy{} // setthrows DOMException;
}

public interface SVGPaint extends SVGColor {

  // Paint Types
//  const unsigned 
	public static final short SVG_PAINTTYPE_UNKNOWN = 0;
//  const unsigned 
	public static final short SVG_PAINTTYPE_RGBCOLOR = 1;
//  const unsigned 
	public static final short SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR = 2;
//  const unsigned 
	public static final short SVG_PAINTTYPE_NONE = 101;
//  const unsigned 
	public static final short SVG_PAINTTYPE_CURRENTCOLOR = 102;
//  const unsigned 
	public static final short SVG_PAINTTYPE_URI_NONE = 103;
//  const unsigned
	public static final short SVG_PAINTTYPE_URI_CURRENTCOLOR = 104;
//  const unsigned 
	public static final short SVG_PAINTTYPE_URI_RGBCOLOR = 105;
//  const unsigned 
	public static final short SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR = 106;
//  const unsigned 
	public static final short SVG_PAINTTYPE_URI = 107;

//  readonly attribute unsigned 
	public short paintType{}
//  readonly attribute 
	public String uri{}

	void setUri(final String uri);
	void setPaint(final /*unsigned*/ short paintType, final String uri, final String rgbColor, final String iccColor) throws SVGException;
}

public interface SVGMarkerElement extends SVGElement,
                             SVGLangSpace,
                             SVGExternalResourcesRequired,
                             SVGStylable,
                             SVGFitToViewBox {

  // Marker Unit Types
//  const unsigned 
	public static final short SVG_MARKERUNITS_UNKNOWN = 0;
//  const unsigned 
	public static final short SVG_MARKERUNITS_USERSPACEONUSE = 1;
//  const unsigned 
	public static final short SVG_MARKERUNITS_STROKEWIDTH = 2;

  // Marker Orientation Types
//  const unsigned 
	public static final short SVG_MARKER_ORIENT_UNKNOWN = 0;
//  const unsigned
	public static final short SVG_MARKER_ORIENT_AUTO = 1;
//  const unsigned 
	public static final short SVG_MARKER_ORIENT_ANGLE = 2;

//  readonly attribute 
	public SVGAnimatedLength refX{}
//  readonly attribute 
	public SVGAnimatedLength refY{}
//  readonly attribute
	public SVGAnimatedEnumeration markerUnits{}
//  readonly attribute 
	public SVGAnimatedLength markerWidth{}
//  readonly attribute 
	public SVGAnimatedLength markerHeight{}
//  readonly attribute 
	public SVGAnimatedEnumeration orientType{}
//  readonly attribute 
	public SVGAnimatedAngle orientAngle{}

	void setOrientToAuto() throws DOMException;
	void setOrientToAngle(final SVGAngle angle) throws DOMException;
}

public interface SVGColorProfileElement extends SVGElement,
                                   SVGURIReference,
                                   SVGRenderingIntent {
//  attribute 
	public String local{}
//  attribute
	public String name{}
//  attribute unsigned
	public short renderingIntent{}
}

public interface SVGColorProfileRule extends SVGCSSRule,
                                SVGRenderingIntent {
//  attribute 
	public String src{} // setthrows DOMException;
//  attribute 
	public String name{} // setthrows DOMException;
//  attribute unsigned 
	public short renderingIntent{} // setthrows DOMException;
}

public interface SVGGradientElement extends SVGElement,
                               SVGURIReference,
                               SVGExternalResourcesRequired,
                               SVGStylable,
                               SVGUnitTypes {

  // Spread Method Types
//  const unsigned 
	public static final short SVG_SPREADMETHOD_UNKNOWN = 0;
//  const unsigned
	public static final short SVG_SPREADMETHOD_PAD = 1;
//  const unsigned 
	public static final short SVG_SPREADMETHOD_REFLECT = 2;
//  const unsigned
	public static final short SVG_SPREADMETHOD_REPEAT = 3;

//  readonly attribute 
	public SVGAnimatedEnumeration gradientUnits{}
//  readonly attribute 
	public SVGAnimatedTransformList gradientTransform{}
//  readonly attribute 
	public SVGAnimatedEnumeration spreadMethod{}
}

public interface SVGLinearGradientElement extends SVGGradientElement {
//  readonly attribute 
	public SVGAnimatedLength x1{}
//  readonly attribute 
	public SVGAnimatedLength y1{}
//  readonly attribute 
	public SVGAnimatedLength x2{}
//  readonly attribute 
	public SVGAnimatedLength y2{}
}

public interface SVGRadialGradientElement extends SVGGradientElement {
//  readonly attribute 
	public SVGAnimatedLength cx{}
//  readonly attribute 
	public SVGAnimatedLength cy{}
//  readonly attribute 
	public SVGAnimatedLength r{}
//  readonly attribute 
	public SVGAnimatedLength fx{}
//  readonly attribute 
	public SVGAnimatedLength fy{}
}

public interface SVGStopElement extends SVGElement,
                           SVGStylable {
//  readonly attribute 
	public SVGAnimatedNumber offset{}
}

public interface SVGPatternElement extends SVGElement,
                              SVGURIReference,
                              SVGTests,
                              SVGLangSpace,
                              SVGExternalResourcesRequired,
                              SVGStylable,
                              SVGFitToViewBox,
                              SVGUnitTypes {
//  readonly attribute 
	public SVGAnimatedEnumeration patternUnits{}
//  readonly attribute 
	public SVGAnimatedEnumeration patternContentUnits{}
//  readonly attribute 
	public SVGAnimatedTransformList patternTransform{}
//  readonly attribute 
	public SVGAnimatedLength x{}
//  readonly attribute 
	public SVGAnimatedLength y{}
//  readonly attribute 
	public SVGAnimatedLength width{}
//  readonly attribute 
	public SVGAnimatedLength height{}
}

public interface SVGClipPathElement extends SVGElement,
                               SVGTests,
                               SVGLangSpace,
                               SVGExternalResourcesRequired,
                               SVGStylable,
                               SVGTransformable,
                               SVGUnitTypes {
//  readonly attribute 
	public SVGAnimatedEnumeration clipPathUnits{}
}

public interface SVGMaskElement extends SVGElement,
                           SVGTests,
                           SVGLangSpace,
                           SVGExternalResourcesRequired,
                           SVGStylable,
                           SVGUnitTypes {
//  readonly attribute 
	public SVGAnimatedEnumeration maskUnits{}
//  readonly attribute 
	public SVGAnimatedEnumeration maskContentUnits{}
//  readonly attribute 
	public SVGAnimatedLength x{}
//  readonly attribute 
	public SVGAnimatedLength y{}
//  readonly attribute 
	public SVGAnimatedLength width{}
//  readonly attribute 
	public SVGAnimatedLength height{}
}

public interface SVGFilterElement extends SVGElement,
                             SVGURIReference,
                             SVGLangSpace,
                             SVGExternalResourcesRequired,
                             SVGStylable,
                             SVGUnitTypes {

//  readonly attribute 
	public SVGAnimatedEnumeration filterUnits{}
//  readonly attribute
	public SVGAnimatedEnumeration primitiveUnits{}
//  readonly attribute
	public SVGAnimatedLength x{}
//  readonly attribute 
	public SVGAnimatedLength y{}
//  readonly attribute 
	public SVGAnimatedLength width{}
//  readonly attribute 
	public SVGAnimatedLength height{}
//  readonly attribute 
	public SVGAnimatedInteger filterResX{}
//  readonly attribute 
	public SVGAnimatedInteger filterResY{}

	void setFilterRes(final /*unsigned*/ long filterResX, final /*unsigned*/ long filterResY) throws DOMException;
}

public interface SVGFilterPrimitiveStandardAttributes extends SVGStylable {
//  readonly attribute 
	public SVGAnimatedLength x{}
//  readonly attribute 
	public SVGAnimatedLength y{}
//  readonly attribute 
	public SVGAnimatedLength width{}
//  readonly attribute 
	public SVGAnimatedLength height{}
//  readonly attribute 
	public SVGAnimatedString result{}
}

public interface SVGFEBlendElement extends SVGElement,
                              SVGFilterPrimitiveStandardAttributes {

  // Blend Mode Types
//  const unsigned 
	public static final short SVG_FEBLEND_MODE_UNKNOWN = 0;
//  const unsigned 
	public static final short SVG_FEBLEND_MODE_NORMAL = 1;
//  const unsigned 
	public static final short SVG_FEBLEND_MODE_MULTIPLY = 2;
//  const unsigned 
	public static final short SVG_FEBLEND_MODE_SCREEN = 3;
//  const unsigned 
	public static final short SVG_FEBLEND_MODE_DARKEN = 4;
//  const unsigned 
	public static final short SVG_FEBLEND_MODE_LIGHTEN = 5;

//  readonly attribute 
	public SVGAnimatedString in1{}
//  readonly attribute 
	public SVGAnimatedString in2{}
//  readonly attribute 
	public SVGAnimatedEnumeration mode{}
}

public interface SVGFEColorMatrixElement extends SVGElement,
                                    SVGFilterPrimitiveStandardAttributes {

  // Color Matrix Types
//  const unsigned 
	public static final short SVG_FECOLORMATRIX_TYPE_UNKNOWN = 0;
//  const unsigned 
	public static final short SVG_FECOLORMATRIX_TYPE_MATRIX = 1;
//  const unsigned 
	public static final short SVG_FECOLORMATRIX_TYPE_SATURATE = 2;
//  const unsigned 
	public static final short SVG_FECOLORMATRIX_TYPE_HUEROTATE = 3;
//  const unsigned 
	public static final short SVG_FECOLORMATRIX_TYPE_LUMINANCETOALPHA = 4;

//  readonly attribute
	public SVGAnimatedString in1{}
//  readonly attribute 
	public SVGAnimatedEnumeration type{}
//  readonly attribute
	public SVGAnimatedNumberList values{}
}

public interface SVGFEComponentTransferElement extends SVGElement,
                                          SVGFilterPrimitiveStandardAttributes {
//  readonly attribute 
	public SVGAnimatedString in1{}
}

public interface SVGComponentTransferFunctionElement extends SVGElement {

  // Component Transfer Types
//  const unsigned 
	public static final short SVG_FECOMPONENTTRANSFER_TYPE_UNKNOWN = 0;
//  const unsigned 
	public static final short SVG_FECOMPONENTTRANSFER_TYPE_IDENTITY = 1;
//  const unsigned 
	public static final short SVG_FECOMPONENTTRANSFER_TYPE_TABLE = 2;
//  const unsigned 
	public static final short SVG_FECOMPONENTTRANSFER_TYPE_DISCRETE = 3;
//  const unsigned 
	public static final short SVG_FECOMPONENTTRANSFER_TYPE_LINEAR = 4;
//  const unsigned 
	public static final short SVG_FECOMPONENTTRANSFER_TYPE_GAMMA = 5;

//  readonly attribute 
	public SVGAnimatedEnumeration type{}
//  readonly attribute
	public SVGAnimatedNumberList tableValues{}
//  readonly attribute 
	public SVGAnimatedNumber slope{}
//  readonly attribute 
	public SVGAnimatedNumber intercept{}
//  readonly attribute 
	public SVGAnimatedNumber amplitude{}
//  readonly attribute
	public SVGAnimatedNumber exponent{}
//  readonly attribute 
	public SVGAnimatedNumber offset{}
}

public interface SVGFEFuncRElement extends SVGComponentTransferFunctionElement {
}

public interface SVGFEFuncGElement extends SVGComponentTransferFunctionElement {
}

public interface SVGFEFuncBElement extends SVGComponentTransferFunctionElement {
}

public interface SVGFEFuncAElement extends SVGComponentTransferFunctionElement {
}

public interface SVGFECompositeElement extends SVGElement,
                                  SVGFilterPrimitiveStandardAttributes {

  // Composite Operators
//  const unsigned 
	public static final short SVG_FECOMPOSITE_OPERATOR_UNKNOWN = 0;
//  const unsigned 
	public static final short SVG_FECOMPOSITE_OPERATOR_OVER = 1;
//  const unsigned
	public static final short SVG_FECOMPOSITE_OPERATOR_IN = 2;
//  const unsigned
	public static final short SVG_FECOMPOSITE_OPERATOR_OUT = 3;
//  const unsigned 
	public static final short SVG_FECOMPOSITE_OPERATOR_ATOP = 4;
//  const unsigned 
	public static final short SVG_FECOMPOSITE_OPERATOR_XOR = 5;
//  const unsigned 
	public static final short SVG_FECOMPOSITE_OPERATOR_ARITHMETIC = 6;

//  readonly attribute 
	public SVGAnimatedString in1{}
//  readonly attribute 
	public SVGAnimatedString in2{}
//  readonly attribute
	public SVGAnimatedEnumeration operator{}
//  readonly attribute
	public SVGAnimatedNumber k1{}
//  readonly attribute
	public SVGAnimatedNumber k2{}
//  readonly attribute 
	public SVGAnimatedNumber k3{}
//  readonly attribute
	public SVGAnimatedNumber k4{}
}

public interface SVGFEConvolveMatrixElement extends SVGElement,
                                       SVGFilterPrimitiveStandardAttributes {

  // Edge Mode Values
//  const unsigned 
	public static final short SVG_EDGEMODE_UNKNOWN = 0;
//  const unsigned 
	public static final short SVG_EDGEMODE_DUPLICATE = 1;
//  const unsigned
	public static final short SVG_EDGEMODE_WRAP = 2;
//  const unsigned 
	public static final short SVG_EDGEMODE_NONE = 3;

//  readonly attribute 
	public SVGAnimatedString in1{}
//  readonly attribute 
	public SVGAnimatedInteger orderX{}
//  readonly attribute
	public SVGAnimatedInteger orderY{}
//  readonly attribute 
	public SVGAnimatedNumberList kernelMatrix{}
//  readonly attribute 
	public SVGAnimatedNumber divisor{}
//  readonly attribute 
	public SVGAnimatedNumber bias{}
//  readonly attribute 
	public SVGAnimatedInteger targetX{}
//  readonly attribute 
	public SVGAnimatedInteger targetY{}
//  readonly attribute 
	public SVGAnimatedEnumeration edgeMode{}
//  readonly attribute 
	public SVGAnimatedNumber kernelUnitLengthX{}
//  readonly attribute
	public SVGAnimatedNumber kernelUnitLengthY{}
//  readonly attribute 
	public SVGAnimatedBoolean preserveAlpha{}
}

public interface SVGFEDiffuseLightingElement extends SVGElement,
                                        SVGFilterPrimitiveStandardAttributes {
//  readonly attribute 
	public SVGAnimatedString in1{}
//  readonly attribute 
	public SVGAnimatedNumber surfaceScale{}
//  readonly attribute
	public SVGAnimatedNumber diffuseConstant{}
//  readonly attribute 
	public SVGAnimatedNumber kernelUnitLengthX{}
//  readonly attribute 
	public SVGAnimatedNumber kernelUnitLengthY{}
}

public interface SVGFEDistantLightElement extends SVGElement {
//  readonly attribute 
	public SVGAnimatedNumber azimuth{}
//  readonly attribute
	public SVGAnimatedNumber elevation{}
}

public interface SVGFEPointLightElement extends SVGElement {
//  readonly attribute 
	public SVGAnimatedNumber x{}
//  readonly attribute 
	public SVGAnimatedNumber y{}
//  readonly attribute
	public SVGAnimatedNumber z{}
}

public interface SVGFESpotLightElement extends SVGElement {
//  readonly attribute 
	public SVGAnimatedNumber x{}
//  readonly attribute 
	public SVGAnimatedNumber y{}
//  readonly attribute 
	public SVGAnimatedNumber z{}
//  readonly attribute 
	public SVGAnimatedNumber pointsAtX{}
//  readonly attribute 
	public SVGAnimatedNumber pointsAtY{}
//  readonly attribute 
	public SVGAnimatedNumber pointsAtZ{}
//  readonly attribute 
	public SVGAnimatedNumber specularExponent{}
//  readonly attribute 
  public SVGAnimatedNumber limitingConeAngle{}
}

public interface SVGFEDisplacementMapElement extends SVGElement,
                                        SVGFilterPrimitiveStandardAttributes {

  // Channel Selectors
//  const unsigned 
	public static final short SVG_CHANNEL_UNKNOWN = 0;
//  const unsigned
	public static final short SVG_CHANNEL_R = 1;
//  const unsigned 
	public static final short SVG_CHANNEL_G = 2;
//  const unsigned 
	public static final short SVG_CHANNEL_B = 3;
//  const unsigned
	public static final short SVG_CHANNEL_A = 4;

//  readonly attribute 
	public SVGAnimatedString in1{}
//  readonly attribute 
	public SVGAnimatedString in2{}
//  readonly attribute 
	public SVGAnimatedNumber scale{}
//  readonly attribute 
	public SVGAnimatedEnumeration xChannelSelector{}
//  readonly attribute 
  public SVGAnimatedEnumeration yChannelSelector{}
}

public interface SVGFEFloodElement extends SVGElement,
                              SVGFilterPrimitiveStandardAttributes {
}

public interface SVGFEGaussianBlurElement extends SVGElement,
                                     SVGFilterPrimitiveStandardAttributes {

//  readonly attribute 
	public SVGAnimatedString in1{}
//  readonly attribute 
	public SVGAnimatedNumber stdDeviationX{}
//  readonly attribute 
	public SVGAnimatedNumber stdDeviationY{}

  void setStdDeviation(final float stdDeviationX, final float stdDeviationY) throws DOMException;
}

public interface SVGFEImageElement extends SVGElement,
                              SVGURIReference,
                              SVGLangSpace,
                              SVGExternalResourcesRequired,
                              SVGFilterPrimitiveStandardAttributes {
//  readonly attribute 
	public SVGAnimatedPreserveAspectRatio preserveAspectRatio{}
}

public interface SVGFEMergeElement extends SVGElement,
                              SVGFilterPrimitiveStandardAttributes {
}

public interface SVGFEMergeNodeElement extends SVGElement {
//  readonly attribute
	public SVGAnimatedString in1{}
}

public interface SVGFEMorphologyElement extends SVGElement,
                                   SVGFilterPrimitiveStandardAttributes {

  // Morphology Operators
//  const unsigned 
	public static final short SVG_MORPHOLOGY_OPERATOR_UNKNOWN = 0;
//  const unsigned
	public static final short SVG_MORPHOLOGY_OPERATOR_ERODE = 1;
//  const unsigned 
	public static final short SVG_MORPHOLOGY_OPERATOR_DILATE = 2;

//  readonly attribute
	public SVGAnimatedString in1{}
//  readonly attribute 
	public SVGAnimatedEnumeration operator{}
//  readonly attribute 
	public SVGAnimatedNumber radiusX{}
//  readonly attribute 
	public SVGAnimatedNumber radiusY{}
}

public interface SVGFEOffsetElement extends SVGElement,
                               SVGFilterPrimitiveStandardAttributes {
//  readonly attribute 
	public SVGAnimatedString in1{}
//  readonly attribute 
	public SVGAnimatedNumber dx{}
//  readonly attribute 
	public SVGAnimatedNumber dy{}
}

public interface SVGFESpecularLightingElement extends SVGElement,
                                         SVGFilterPrimitiveStandardAttributes {
//  readonly attribute 
	public SVGAnimatedString in1{}
//  readonly attribute 
  public SVGAnimatedNumber surfaceScale{}
//  readonly attribute 
  public SVGAnimatedNumber specularConstant{}
//  readonly attribute 
  public SVGAnimatedNumber specularExponent{}
//  readonly attribute 
  public SVGAnimatedNumber kernelUnitLengthX{}
//  readonly attribute
  public SVGAnimatedNumber kernelUnitLengthY{}
}

public interface SVGFETileElement extends SVGElement,
                             SVGFilterPrimitiveStandardAttributes {
//  readonly attribute 
	public SVGAnimatedString in1{}
}

public interface SVGFETurbulenceElement extends SVGElement,
                                   SVGFilterPrimitiveStandardAttributes {

  // Turbulence Types
//  const unsigned 
	public static final short SVG_TURBULENCE_TYPE_UNKNOWN = 0;
//  const unsigned 
	public static final short SVG_TURBULENCE_TYPE_FRACTALNOISE = 1;
//  const unsigned 
	public static final short SVG_TURBULENCE_TYPE_TURBULENCE = 2;

  // Stitch Options
//  const unsigned 
	public static final short SVG_STITCHTYPE_UNKNOWN = 0;
//  const unsigned 
	public static final short SVG_STITCHTYPE_STITCH = 1;
//  const unsigned 
	public static final short SVG_STITCHTYPE_NOSTITCH = 2;

//  readonly attribute 
	public SVGAnimatedNumber baseFrequencyX{}
//  readonly attribute 
	public SVGAnimatedNumber baseFrequencyY{}
//  readonly attribute 
	public SVGAnimatedInteger numOctaves{}
//  readonly attribute 
	public SVGAnimatedNumber seed{}
//  readonly attribute 
	public SVGAnimatedEnumeration stitchTiles{}
//  readonly attribute
	public SVGAnimatedEnumeration type{}
}

public interface SVGCursorElement extends SVGElement,
                             SVGURIReference,
                             SVGTests,
                             SVGExternalResourcesRequired {
//  readonly attribute 
	public SVGAnimatedLength x{}
//  readonly attribute 
	public SVGAnimatedLength y{}
}

public interface SVGAElement extends SVGElement,
                        SVGURIReference,
                        SVGTests,
                        SVGLangSpace,
                        SVGExternalResourcesRequired,
                        SVGStylable,
                        SVGTransformable {
//  readonly attribute
	public SVGAnimatedString target{}
}

public interface SVGViewElement extends SVGElement,
                           SVGExternalResourcesRequired,
                           SVGFitToViewBox,
                           SVGZoomAndPan {
//  readonly attribute
	public SVGStringList viewTarget{}
}

public interface SVGScriptElement extends SVGElement,
                             SVGURIReference,
                             SVGExternalResourcesRequired {
//  attribute 
	public String type{} // setthrows DOMException;
}

public interface SVGZoomEvent extends UIEvent {
//  readonly attribute 
	public SVGRect zoomRectScreen{}
//  readonly attribute 
	public float previousScale{}
//  readonly attribute
	public SVGPoint previousTranslate{}
//  readonly attribute 
	public float newScale{}
//  readonly attribute 
	public SVGPoint newTranslate{}
}

public interface SVGAnimationElement extends SVGElement,
                                SVGTests,
                                SVGExternalResourcesRequired,
                                ElementTimeControl {

//  readonly attribute 
	public SVGElement targetElement{}

	float getStartTime() throws DOMException;
	float getCurrentTime();
	float getSimpleDuration() throws DOMException;
}

public interface SVGAnimateElement extends SVGAnimationElement,
                              SVGStylable {
}

public interface SVGSetElement extends SVGAnimationElement {
}

public interface SVGAnimateMotionElement extends SVGAnimationElement {
}

public interface SVGMPathElement extends SVGElement,
                            SVGURIReference,
                            SVGExternalResourcesRequired {
}

public interface SVGAnimateColorElement extends SVGAnimationElement,
                                   SVGStylable {
}

public interface SVGAnimateTransformElement extends SVGAnimationElement {
}

public interface SVGFontElement extends SVGElement,
                           SVGExternalResourcesRequired,
                           SVGStylable {
}

public interface SVGGlyphElement extends SVGElement,
                            SVGStylable {
}

public interface SVGMissingGlyphElement extends SVGElement,
                                   SVGStylable {
}

public interface SVGHKernElement extends SVGElement {
}

public interface SVGVKernElement extends SVGElement {
}

public interface SVGFontFaceElement extends SVGElement {
}

public interface SVGFontFaceSrcElement extends SVGElement {
}

public interface SVGFontFaceUriElement extends SVGElement {
}

public interface SVGFontFaceFormatElement extends SVGElement {
}

public interface SVGFontFaceNameElement extends SVGElement {
}

public interface SVGMetadataElement extends SVGElement {
}

public interface SVGForeignObjectElement extends SVGElement,
                                    SVGTests,
                                    SVGLangSpace,
                                    SVGExternalResourcesRequired,
                                    SVGStylable,
                                    SVGTransformable {
//  readonly attribute 
	public SVGAnimatedLength x{}
//  readonly attribute 
	public SVGAnimatedLength y{}
//  readonly attribute
	public SVGAnimatedLength width{}
//  readonly attribute 
	public SVGAnimatedLength height{}
}

interface ElementTimeControl {
	void beginElement();
	void beginElementAt(final float offset);
	void endElement();
	void endElementAt(final float offset);
}


interface TimeEvent extends Event {

//	readonly attribute 
	AbstractView view{}
//	readonly attribute 
	long detail{}

	void initTimeEvent(final String typeArg, final AbstractView viewArg, final long detailArg);

}

