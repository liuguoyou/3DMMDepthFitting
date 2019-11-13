/**
 * Generated by Scrooge
 *   version: 18.4.0
 *   rev: b64bcb47af2451b2e51a1ed1b3876f6c06c642b3
 *   built at: 20180410-144039
 */
package ch.unibas.cs.gravis.realsense

import com.twitter.io.Buf
import com.twitter.scrooge.{
  LazyTProtocol,
  TFieldBlob,
  ThriftException,
  ThriftStruct,
  ThriftStructCodec3,
  ThriftStructFieldInfo,
  ThriftStructMetaData,
  ThriftUtil,
  ValidatingThriftStruct,
  ValidatingThriftStructCodec3
}
import org.apache.thrift.protocol._
import org.apache.thrift.transport.{TMemoryBuffer, TTransport, TIOStreamTransport}
import java.io.ByteArrayInputStream
import java.nio.ByteBuffer
import java.util.Arrays
import java.util.concurrent.atomic.AtomicInteger
import scala.collection.immutable.{Map => immutable$Map}
import scala.collection.mutable.Builder
import scala.collection.mutable.{
  ArrayBuffer => mutable$ArrayBuffer, Buffer => mutable$Buffer,
  HashMap => mutable$HashMap, HashSet => mutable$HashSet}
import scala.collection.{Map, Set}


object ThriftUncertaintyCovariance extends ValidatingThriftStructCodec3[ThriftUncertaintyCovariance] {
  val NoPassthroughFields: immutable$Map[Short, TFieldBlob] = immutable$Map.empty[Short, TFieldBlob]
  val Struct = new TStruct("ThriftUncertaintyCovariance")
  val VariancesField = new TField("variances", TType.STRUCT, 1)
  val VariancesFieldManifest = implicitly[Manifest[ch.unibas.cs.gravis.realsense.ThriftVector3D]]
  val PrincipalAxis1Field = new TField("principalAxis1", TType.STRUCT, 2)
  val PrincipalAxis1FieldManifest = implicitly[Manifest[ch.unibas.cs.gravis.realsense.ThriftVector3D]]
  val PrincipalAxis2Field = new TField("principalAxis2", TType.STRUCT, 3)
  val PrincipalAxis2FieldManifest = implicitly[Manifest[ch.unibas.cs.gravis.realsense.ThriftVector3D]]
  val PrincipalAxis3Field = new TField("principalAxis3", TType.STRUCT, 4)
  val PrincipalAxis3FieldManifest = implicitly[Manifest[ch.unibas.cs.gravis.realsense.ThriftVector3D]]

  /**
   * Field information in declaration order.
   */
  lazy val fieldInfos: scala.List[ThriftStructFieldInfo] = scala.List[ThriftStructFieldInfo](
    new ThriftStructFieldInfo(
      VariancesField,
      false,
      true,
      VariancesFieldManifest,
      _root_.scala.None,
      _root_.scala.None,
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String],
      None
    ),
    new ThriftStructFieldInfo(
      PrincipalAxis1Field,
      false,
      true,
      PrincipalAxis1FieldManifest,
      _root_.scala.None,
      _root_.scala.None,
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String],
      None
    ),
    new ThriftStructFieldInfo(
      PrincipalAxis2Field,
      false,
      true,
      PrincipalAxis2FieldManifest,
      _root_.scala.None,
      _root_.scala.None,
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String],
      None
    ),
    new ThriftStructFieldInfo(
      PrincipalAxis3Field,
      false,
      true,
      PrincipalAxis3FieldManifest,
      _root_.scala.None,
      _root_.scala.None,
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String],
      None
    )
  )

  lazy val structAnnotations: immutable$Map[String, String] =
    immutable$Map.empty[String, String]

  /**
   * Checks that all required fields are non-null.
   */
  def validate(_item: ThriftUncertaintyCovariance): Unit = {
    if (_item.variances == null) throw new TProtocolException("Required field variances cannot be null")
    if (_item.principalAxis1 == null) throw new TProtocolException("Required field principalAxis1 cannot be null")
    if (_item.principalAxis2 == null) throw new TProtocolException("Required field principalAxis2 cannot be null")
    if (_item.principalAxis3 == null) throw new TProtocolException("Required field principalAxis3 cannot be null")
  }

  /**
   * Checks that the struct is a valid as a new instance. If there are any missing required or
   * construction required fields, return a non-empty list.
   */
  def validateNewInstance(item: ThriftUncertaintyCovariance): scala.Seq[com.twitter.scrooge.validation.Issue] = {
    val buf = scala.collection.mutable.ListBuffer.empty[com.twitter.scrooge.validation.Issue]

    if (item.variances == null)
      buf += com.twitter.scrooge.validation.MissingRequiredField(fieldInfos.apply(0))
    buf ++= validateField(item.variances)
    if (item.principalAxis1 == null)
      buf += com.twitter.scrooge.validation.MissingRequiredField(fieldInfos.apply(1))
    buf ++= validateField(item.principalAxis1)
    if (item.principalAxis2 == null)
      buf += com.twitter.scrooge.validation.MissingRequiredField(fieldInfos.apply(2))
    buf ++= validateField(item.principalAxis2)
    if (item.principalAxis3 == null)
      buf += com.twitter.scrooge.validation.MissingRequiredField(fieldInfos.apply(3))
    buf ++= validateField(item.principalAxis3)
    buf.toList
  }

  def withoutPassthroughFields(original: ThriftUncertaintyCovariance): ThriftUncertaintyCovariance =
    new Immutable(
      variances =
        {
          val field = original.variances
          ch.unibas.cs.gravis.realsense.ThriftVector3D.withoutPassthroughFields(field)
        },
      principalAxis1 =
        {
          val field = original.principalAxis1
          ch.unibas.cs.gravis.realsense.ThriftVector3D.withoutPassthroughFields(field)
        },
      principalAxis2 =
        {
          val field = original.principalAxis2
          ch.unibas.cs.gravis.realsense.ThriftVector3D.withoutPassthroughFields(field)
        },
      principalAxis3 =
        {
          val field = original.principalAxis3
          ch.unibas.cs.gravis.realsense.ThriftVector3D.withoutPassthroughFields(field)
        }
    )

  override def encode(_item: ThriftUncertaintyCovariance, _oproto: TProtocol): Unit = {
    _item.write(_oproto)
  }


  private[this] def lazyDecode(_iprot: LazyTProtocol): ThriftUncertaintyCovariance = {

    var variances: ch.unibas.cs.gravis.realsense.ThriftVector3D = null
    var _got_variances = false
    var principalAxis1: ch.unibas.cs.gravis.realsense.ThriftVector3D = null
    var _got_principalAxis1 = false
    var principalAxis2: ch.unibas.cs.gravis.realsense.ThriftVector3D = null
    var _got_principalAxis2 = false
    var principalAxis3: ch.unibas.cs.gravis.realsense.ThriftVector3D = null
    var _got_principalAxis3 = false

    var _passthroughFields: Builder[(Short, TFieldBlob), immutable$Map[Short, TFieldBlob]] = null
    var _done = false
    val _start_offset = _iprot.offset

    _iprot.readStructBegin()
    while (!_done) {
      val _field = _iprot.readFieldBegin()
      if (_field.`type` == TType.STOP) {
        _done = true
      } else {
        _field.id match {
          case 1 =>
            _field.`type` match {
              case TType.STRUCT =>
    
                variances = readVariancesValue(_iprot)
                _got_variances = true
              case _actualType =>
                val _expectedType = TType.STRUCT
                throw new TProtocolException(
                  "Received wrong type for field 'variances' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 2 =>
            _field.`type` match {
              case TType.STRUCT =>
    
                principalAxis1 = readPrincipalAxis1Value(_iprot)
                _got_principalAxis1 = true
              case _actualType =>
                val _expectedType = TType.STRUCT
                throw new TProtocolException(
                  "Received wrong type for field 'principalAxis1' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 3 =>
            _field.`type` match {
              case TType.STRUCT =>
    
                principalAxis2 = readPrincipalAxis2Value(_iprot)
                _got_principalAxis2 = true
              case _actualType =>
                val _expectedType = TType.STRUCT
                throw new TProtocolException(
                  "Received wrong type for field 'principalAxis2' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 4 =>
            _field.`type` match {
              case TType.STRUCT =>
    
                principalAxis3 = readPrincipalAxis3Value(_iprot)
                _got_principalAxis3 = true
              case _actualType =>
                val _expectedType = TType.STRUCT
                throw new TProtocolException(
                  "Received wrong type for field 'principalAxis3' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case _ =>
            if (_passthroughFields == null)
              _passthroughFields = immutable$Map.newBuilder[Short, TFieldBlob]
            _passthroughFields += (_field.id -> TFieldBlob.read(_field, _iprot))
        }
        _iprot.readFieldEnd()
      }
    }
    _iprot.readStructEnd()

    if (!_got_variances) throw new TProtocolException("Required field 'variances' was not found in serialized data for struct ThriftUncertaintyCovariance")
    if (!_got_principalAxis1) throw new TProtocolException("Required field 'principalAxis1' was not found in serialized data for struct ThriftUncertaintyCovariance")
    if (!_got_principalAxis2) throw new TProtocolException("Required field 'principalAxis2' was not found in serialized data for struct ThriftUncertaintyCovariance")
    if (!_got_principalAxis3) throw new TProtocolException("Required field 'principalAxis3' was not found in serialized data for struct ThriftUncertaintyCovariance")
    new LazyImmutable(
      _iprot,
      _iprot.buffer,
      _start_offset,
      _iprot.offset,
      variances,
      principalAxis1,
      principalAxis2,
      principalAxis3,
      if (_passthroughFields == null)
        NoPassthroughFields
      else
        _passthroughFields.result()
    )
  }

  override def decode(_iprot: TProtocol): ThriftUncertaintyCovariance =
    _iprot match {
      case i: LazyTProtocol => lazyDecode(i)
      case i => eagerDecode(i)
    }

  private[realsense] def eagerDecode(_iprot: TProtocol): ThriftUncertaintyCovariance = {
    var variances: ch.unibas.cs.gravis.realsense.ThriftVector3D = null
    var _got_variances = false
    var principalAxis1: ch.unibas.cs.gravis.realsense.ThriftVector3D = null
    var _got_principalAxis1 = false
    var principalAxis2: ch.unibas.cs.gravis.realsense.ThriftVector3D = null
    var _got_principalAxis2 = false
    var principalAxis3: ch.unibas.cs.gravis.realsense.ThriftVector3D = null
    var _got_principalAxis3 = false
    var _passthroughFields: Builder[(Short, TFieldBlob), immutable$Map[Short, TFieldBlob]] = null
    var _done = false

    _iprot.readStructBegin()
    while (!_done) {
      val _field = _iprot.readFieldBegin()
      if (_field.`type` == TType.STOP) {
        _done = true
      } else {
        _field.id match {
          case 1 =>
            _field.`type` match {
              case TType.STRUCT =>
                variances = readVariancesValue(_iprot)
                _got_variances = true
              case _actualType =>
                val _expectedType = TType.STRUCT
                throw new TProtocolException(
                  "Received wrong type for field 'variances' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 2 =>
            _field.`type` match {
              case TType.STRUCT =>
                principalAxis1 = readPrincipalAxis1Value(_iprot)
                _got_principalAxis1 = true
              case _actualType =>
                val _expectedType = TType.STRUCT
                throw new TProtocolException(
                  "Received wrong type for field 'principalAxis1' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 3 =>
            _field.`type` match {
              case TType.STRUCT =>
                principalAxis2 = readPrincipalAxis2Value(_iprot)
                _got_principalAxis2 = true
              case _actualType =>
                val _expectedType = TType.STRUCT
                throw new TProtocolException(
                  "Received wrong type for field 'principalAxis2' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 4 =>
            _field.`type` match {
              case TType.STRUCT =>
                principalAxis3 = readPrincipalAxis3Value(_iprot)
                _got_principalAxis3 = true
              case _actualType =>
                val _expectedType = TType.STRUCT
                throw new TProtocolException(
                  "Received wrong type for field 'principalAxis3' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case _ =>
            if (_passthroughFields == null)
              _passthroughFields = immutable$Map.newBuilder[Short, TFieldBlob]
            _passthroughFields += (_field.id -> TFieldBlob.read(_field, _iprot))
        }
        _iprot.readFieldEnd()
      }
    }
    _iprot.readStructEnd()

    if (!_got_variances) throw new TProtocolException("Required field 'variances' was not found in serialized data for struct ThriftUncertaintyCovariance")
    if (!_got_principalAxis1) throw new TProtocolException("Required field 'principalAxis1' was not found in serialized data for struct ThriftUncertaintyCovariance")
    if (!_got_principalAxis2) throw new TProtocolException("Required field 'principalAxis2' was not found in serialized data for struct ThriftUncertaintyCovariance")
    if (!_got_principalAxis3) throw new TProtocolException("Required field 'principalAxis3' was not found in serialized data for struct ThriftUncertaintyCovariance")
    new Immutable(
      variances,
      principalAxis1,
      principalAxis2,
      principalAxis3,
      if (_passthroughFields == null)
        NoPassthroughFields
      else
        _passthroughFields.result()
    )
  }

  def apply(
    variances: ch.unibas.cs.gravis.realsense.ThriftVector3D,
    principalAxis1: ch.unibas.cs.gravis.realsense.ThriftVector3D,
    principalAxis2: ch.unibas.cs.gravis.realsense.ThriftVector3D,
    principalAxis3: ch.unibas.cs.gravis.realsense.ThriftVector3D
  ): ThriftUncertaintyCovariance =
    new Immutable(
      variances,
      principalAxis1,
      principalAxis2,
      principalAxis3
    )

  def unapply(_item: ThriftUncertaintyCovariance): _root_.scala.Option[_root_.scala.Tuple4[ch.unibas.cs.gravis.realsense.ThriftVector3D, ch.unibas.cs.gravis.realsense.ThriftVector3D, ch.unibas.cs.gravis.realsense.ThriftVector3D, ch.unibas.cs.gravis.realsense.ThriftVector3D]] = _root_.scala.Some(_item.toTuple)


  @inline private[realsense] def readVariancesValue(_iprot: TProtocol): ch.unibas.cs.gravis.realsense.ThriftVector3D = {
    ch.unibas.cs.gravis.realsense.ThriftVector3D.decode(_iprot)
  }

  @inline private def writeVariancesField(variances_item: ch.unibas.cs.gravis.realsense.ThriftVector3D, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(VariancesField)
    writeVariancesValue(variances_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeVariancesValue(variances_item: ch.unibas.cs.gravis.realsense.ThriftVector3D, _oprot: TProtocol): Unit = {
    variances_item.write(_oprot)
  }

  @inline private[realsense] def readPrincipalAxis1Value(_iprot: TProtocol): ch.unibas.cs.gravis.realsense.ThriftVector3D = {
    ch.unibas.cs.gravis.realsense.ThriftVector3D.decode(_iprot)
  }

  @inline private def writePrincipalAxis1Field(principalAxis1_item: ch.unibas.cs.gravis.realsense.ThriftVector3D, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(PrincipalAxis1Field)
    writePrincipalAxis1Value(principalAxis1_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writePrincipalAxis1Value(principalAxis1_item: ch.unibas.cs.gravis.realsense.ThriftVector3D, _oprot: TProtocol): Unit = {
    principalAxis1_item.write(_oprot)
  }

  @inline private[realsense] def readPrincipalAxis2Value(_iprot: TProtocol): ch.unibas.cs.gravis.realsense.ThriftVector3D = {
    ch.unibas.cs.gravis.realsense.ThriftVector3D.decode(_iprot)
  }

  @inline private def writePrincipalAxis2Field(principalAxis2_item: ch.unibas.cs.gravis.realsense.ThriftVector3D, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(PrincipalAxis2Field)
    writePrincipalAxis2Value(principalAxis2_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writePrincipalAxis2Value(principalAxis2_item: ch.unibas.cs.gravis.realsense.ThriftVector3D, _oprot: TProtocol): Unit = {
    principalAxis2_item.write(_oprot)
  }

  @inline private[realsense] def readPrincipalAxis3Value(_iprot: TProtocol): ch.unibas.cs.gravis.realsense.ThriftVector3D = {
    ch.unibas.cs.gravis.realsense.ThriftVector3D.decode(_iprot)
  }

  @inline private def writePrincipalAxis3Field(principalAxis3_item: ch.unibas.cs.gravis.realsense.ThriftVector3D, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(PrincipalAxis3Field)
    writePrincipalAxis3Value(principalAxis3_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writePrincipalAxis3Value(principalAxis3_item: ch.unibas.cs.gravis.realsense.ThriftVector3D, _oprot: TProtocol): Unit = {
    principalAxis3_item.write(_oprot)
  }


  object Immutable extends ThriftStructCodec3[ThriftUncertaintyCovariance] {
    override def encode(_item: ThriftUncertaintyCovariance, _oproto: TProtocol): Unit = { _item.write(_oproto) }
    override def decode(_iprot: TProtocol): ThriftUncertaintyCovariance = ThriftUncertaintyCovariance.decode(_iprot)
    override lazy val metaData: ThriftStructMetaData[ThriftUncertaintyCovariance] = ThriftUncertaintyCovariance.metaData
  }

  /**
   * The default read-only implementation of ThriftUncertaintyCovariance.  You typically should not need to
   * directly reference this class; instead, use the ThriftUncertaintyCovariance.apply method to construct
   * new instances.
   */
  class Immutable(
      val variances: ch.unibas.cs.gravis.realsense.ThriftVector3D,
      val principalAxis1: ch.unibas.cs.gravis.realsense.ThriftVector3D,
      val principalAxis2: ch.unibas.cs.gravis.realsense.ThriftVector3D,
      val principalAxis3: ch.unibas.cs.gravis.realsense.ThriftVector3D,
      override val _passthroughFields: immutable$Map[Short, TFieldBlob])
    extends ThriftUncertaintyCovariance {
    def this(
      variances: ch.unibas.cs.gravis.realsense.ThriftVector3D,
      principalAxis1: ch.unibas.cs.gravis.realsense.ThriftVector3D,
      principalAxis2: ch.unibas.cs.gravis.realsense.ThriftVector3D,
      principalAxis3: ch.unibas.cs.gravis.realsense.ThriftVector3D
    ) = this(
      variances,
      principalAxis1,
      principalAxis2,
      principalAxis3,
      Map.empty[Short, TFieldBlob]
    )
  }

  /**
   * This is another Immutable, this however keeps strings as lazy values that are lazily decoded from the backing
   * array byte on read.
   */
  private[this] class LazyImmutable(
      _proto: LazyTProtocol,
      _buf: Array[Byte],
      _start_offset: Int,
      _end_offset: Int,
      val variances: ch.unibas.cs.gravis.realsense.ThriftVector3D,
      val principalAxis1: ch.unibas.cs.gravis.realsense.ThriftVector3D,
      val principalAxis2: ch.unibas.cs.gravis.realsense.ThriftVector3D,
      val principalAxis3: ch.unibas.cs.gravis.realsense.ThriftVector3D,
      override val _passthroughFields: immutable$Map[Short, TFieldBlob])
    extends ThriftUncertaintyCovariance {

    override def write(_oprot: TProtocol): Unit = {
      _oprot match {
        case i: LazyTProtocol => i.writeRaw(_buf, _start_offset, _end_offset - _start_offset)
        case _ => super.write(_oprot)
      }
    }


    /**
     * Override the super hash code to make it a lazy val rather than def.
     *
     * Calculating the hash code can be expensive, caching it where possible
     * can provide significant performance wins. (Key in a hash map for instance)
     * Usually not safe since the normal constructor will accept a mutable map or
     * set as an arg
     * Here however we control how the class is generated from serialized data.
     * With the class private and the contract that we throw away our mutable references
     * having the hash code lazy here is safe.
     */
    override lazy val hashCode = super.hashCode
  }

  /**
   * This Proxy trait allows you to extend the ThriftUncertaintyCovariance trait with additional state or
   * behavior and implement the read-only methods from ThriftUncertaintyCovariance using an underlying
   * instance.
   */
  trait Proxy extends ThriftUncertaintyCovariance {
    protected def _underlying_ThriftUncertaintyCovariance: ThriftUncertaintyCovariance
    override def variances: ch.unibas.cs.gravis.realsense.ThriftVector3D = _underlying_ThriftUncertaintyCovariance.variances
    override def principalAxis1: ch.unibas.cs.gravis.realsense.ThriftVector3D = _underlying_ThriftUncertaintyCovariance.principalAxis1
    override def principalAxis2: ch.unibas.cs.gravis.realsense.ThriftVector3D = _underlying_ThriftUncertaintyCovariance.principalAxis2
    override def principalAxis3: ch.unibas.cs.gravis.realsense.ThriftVector3D = _underlying_ThriftUncertaintyCovariance.principalAxis3
    override def _passthroughFields = _underlying_ThriftUncertaintyCovariance._passthroughFields
  }
}

/**
 * Prefer the companion object's [[ch.unibas.cs.gravis.realsense.ThriftUncertaintyCovariance.apply]]
 * for construction if you don't need to specify passthrough fields.
 */
trait ThriftUncertaintyCovariance
  extends ThriftStruct
  with _root_.scala.Product4[ch.unibas.cs.gravis.realsense.ThriftVector3D, ch.unibas.cs.gravis.realsense.ThriftVector3D, ch.unibas.cs.gravis.realsense.ThriftVector3D, ch.unibas.cs.gravis.realsense.ThriftVector3D]
  with ValidatingThriftStruct[ThriftUncertaintyCovariance]
  with java.io.Serializable
{
  import ThriftUncertaintyCovariance._

  def variances: ch.unibas.cs.gravis.realsense.ThriftVector3D
  def principalAxis1: ch.unibas.cs.gravis.realsense.ThriftVector3D
  def principalAxis2: ch.unibas.cs.gravis.realsense.ThriftVector3D
  def principalAxis3: ch.unibas.cs.gravis.realsense.ThriftVector3D

  def _passthroughFields: immutable$Map[Short, TFieldBlob] = immutable$Map.empty

  def _1 = variances
  def _2 = principalAxis1
  def _3 = principalAxis2
  def _4 = principalAxis3

  def toTuple: _root_.scala.Tuple4[ch.unibas.cs.gravis.realsense.ThriftVector3D, ch.unibas.cs.gravis.realsense.ThriftVector3D, ch.unibas.cs.gravis.realsense.ThriftVector3D, ch.unibas.cs.gravis.realsense.ThriftVector3D] = {
    (
      variances,
      principalAxis1,
      principalAxis2,
      principalAxis3
    )
  }


  /**
   * Gets a field value encoded as a binary blob using TCompactProtocol.  If the specified field
   * is present in the passthrough map, that value is returned.  Otherwise, if the specified field
   * is known and not optional and set to None, then the field is serialized and returned.
   */
  def getFieldBlob(_fieldId: Short): _root_.scala.Option[TFieldBlob] = {
    lazy val _buff = new TMemoryBuffer(32)
    lazy val _oprot = new TCompactProtocol(_buff)
    _passthroughFields.get(_fieldId) match {
      case blob: _root_.scala.Some[TFieldBlob] => blob
      case _root_.scala.None => {
        val _fieldOpt: _root_.scala.Option[TField] =
          _fieldId match {
            case 1 =>
              if (variances ne null) {
                writeVariancesValue(variances, _oprot)
                _root_.scala.Some(ThriftUncertaintyCovariance.VariancesField)
              } else {
                _root_.scala.None
              }
            case 2 =>
              if (principalAxis1 ne null) {
                writePrincipalAxis1Value(principalAxis1, _oprot)
                _root_.scala.Some(ThriftUncertaintyCovariance.PrincipalAxis1Field)
              } else {
                _root_.scala.None
              }
            case 3 =>
              if (principalAxis2 ne null) {
                writePrincipalAxis2Value(principalAxis2, _oprot)
                _root_.scala.Some(ThriftUncertaintyCovariance.PrincipalAxis2Field)
              } else {
                _root_.scala.None
              }
            case 4 =>
              if (principalAxis3 ne null) {
                writePrincipalAxis3Value(principalAxis3, _oprot)
                _root_.scala.Some(ThriftUncertaintyCovariance.PrincipalAxis3Field)
              } else {
                _root_.scala.None
              }
            case _ => _root_.scala.None
          }
        _fieldOpt match {
          case _root_.scala.Some(_field) =>
            _root_.scala.Some(TFieldBlob(_field, Buf.ByteArray.Owned(_buff.getArray())))
          case _root_.scala.None =>
            _root_.scala.None
        }
      }
    }
  }

  /**
   * Collects TCompactProtocol-encoded field values according to `getFieldBlob` into a map.
   */
  def getFieldBlobs(ids: TraversableOnce[Short]): immutable$Map[Short, TFieldBlob] =
    (ids flatMap { id => getFieldBlob(id) map { id -> _ } }).toMap

  /**
   * Sets a field using a TCompactProtocol-encoded binary blob.  If the field is a known
   * field, the blob is decoded and the field is set to the decoded value.  If the field
   * is unknown and passthrough fields are enabled, then the blob will be stored in
   * _passthroughFields.
   */
  def setField(_blob: TFieldBlob): ThriftUncertaintyCovariance = {
    var variances: ch.unibas.cs.gravis.realsense.ThriftVector3D = this.variances
    var principalAxis1: ch.unibas.cs.gravis.realsense.ThriftVector3D = this.principalAxis1
    var principalAxis2: ch.unibas.cs.gravis.realsense.ThriftVector3D = this.principalAxis2
    var principalAxis3: ch.unibas.cs.gravis.realsense.ThriftVector3D = this.principalAxis3
    var _passthroughFields = this._passthroughFields
    _blob.id match {
      case 1 =>
        variances = readVariancesValue(_blob.read)
      case 2 =>
        principalAxis1 = readPrincipalAxis1Value(_blob.read)
      case 3 =>
        principalAxis2 = readPrincipalAxis2Value(_blob.read)
      case 4 =>
        principalAxis3 = readPrincipalAxis3Value(_blob.read)
      case _ => _passthroughFields += (_blob.id -> _blob)
    }
    new Immutable(
      variances,
      principalAxis1,
      principalAxis2,
      principalAxis3,
      _passthroughFields
    )
  }

  /**
   * If the specified field is optional, it is set to None.  Otherwise, if the field is
   * known, it is reverted to its default value; if the field is unknown, it is removed
   * from the passthroughFields map, if present.
   */
  def unsetField(_fieldId: Short): ThriftUncertaintyCovariance = {
    var variances: ch.unibas.cs.gravis.realsense.ThriftVector3D = this.variances
    var principalAxis1: ch.unibas.cs.gravis.realsense.ThriftVector3D = this.principalAxis1
    var principalAxis2: ch.unibas.cs.gravis.realsense.ThriftVector3D = this.principalAxis2
    var principalAxis3: ch.unibas.cs.gravis.realsense.ThriftVector3D = this.principalAxis3

    _fieldId match {
      case 1 =>
        variances = null
      case 2 =>
        principalAxis1 = null
      case 3 =>
        principalAxis2 = null
      case 4 =>
        principalAxis3 = null
      case _ =>
    }
    new Immutable(
      variances,
      principalAxis1,
      principalAxis2,
      principalAxis3,
      _passthroughFields - _fieldId
    )
  }

  /**
   * If the specified field is optional, it is set to None.  Otherwise, if the field is
   * known, it is reverted to its default value; if the field is unknown, it is removed
   * from the passthroughFields map, if present.
   */
  def unsetVariances: ThriftUncertaintyCovariance = unsetField(1)

  def unsetPrincipalAxis1: ThriftUncertaintyCovariance = unsetField(2)

  def unsetPrincipalAxis2: ThriftUncertaintyCovariance = unsetField(3)

  def unsetPrincipalAxis3: ThriftUncertaintyCovariance = unsetField(4)


  override def write(_oprot: TProtocol): Unit = {
    ThriftUncertaintyCovariance.validate(this)
    _oprot.writeStructBegin(Struct)
    if (variances ne null) writeVariancesField(variances, _oprot)
    if (principalAxis1 ne null) writePrincipalAxis1Field(principalAxis1, _oprot)
    if (principalAxis2 ne null) writePrincipalAxis2Field(principalAxis2, _oprot)
    if (principalAxis3 ne null) writePrincipalAxis3Field(principalAxis3, _oprot)
    if (_passthroughFields.nonEmpty) {
      _passthroughFields.values.foreach { _.write(_oprot) }
    }
    _oprot.writeFieldStop()
    _oprot.writeStructEnd()
  }

  def copy(
    variances: ch.unibas.cs.gravis.realsense.ThriftVector3D = this.variances,
    principalAxis1: ch.unibas.cs.gravis.realsense.ThriftVector3D = this.principalAxis1,
    principalAxis2: ch.unibas.cs.gravis.realsense.ThriftVector3D = this.principalAxis2,
    principalAxis3: ch.unibas.cs.gravis.realsense.ThriftVector3D = this.principalAxis3,
    _passthroughFields: immutable$Map[Short, TFieldBlob] = this._passthroughFields
  ): ThriftUncertaintyCovariance =
    new Immutable(
      variances,
      principalAxis1,
      principalAxis2,
      principalAxis3,
      _passthroughFields
    )

  override def canEqual(other: Any): Boolean = other.isInstanceOf[ThriftUncertaintyCovariance]

  private def _equals(x: ThriftUncertaintyCovariance, y: ThriftUncertaintyCovariance): Boolean =
      x.productArity == y.productArity &&
      x.productIterator.sameElements(y.productIterator)

  override def equals(other: Any): Boolean =
    canEqual(other) &&
      _equals(this, other.asInstanceOf[ThriftUncertaintyCovariance]) &&
      _passthroughFields == other.asInstanceOf[ThriftUncertaintyCovariance]._passthroughFields

  override def hashCode: Int = _root_.scala.runtime.ScalaRunTime._hashCode(this)

  override def toString: String = _root_.scala.runtime.ScalaRunTime._toString(this)


  override def productArity: Int = 4

  override def productElement(n: Int): Any = n match {
    case 0 => this.variances
    case 1 => this.principalAxis1
    case 2 => this.principalAxis2
    case 3 => this.principalAxis3
    case _ => throw new IndexOutOfBoundsException(n.toString)
  }

  override def productPrefix: String = "ThriftUncertaintyCovariance"

  def _codec: ValidatingThriftStructCodec3[ThriftUncertaintyCovariance] = ThriftUncertaintyCovariance
}

