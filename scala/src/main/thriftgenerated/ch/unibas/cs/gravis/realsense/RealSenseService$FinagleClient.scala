/**
 * Generated by Scrooge
 *   version: 18.4.0
 *   rev: b64bcb47af2451b2e51a1ed1b3876f6c06c642b3
 *   built at: 20180410-144039
 */
package ch.unibas.cs.gravis.realsense

import com.twitter.finagle.SourcedException
import com.twitter.finagle.{service => ctfs}
import com.twitter.finagle.stats.{NullStatsReceiver, StatsReceiver}
import com.twitter.finagle.thrift.{Protocols,RichClientParam, ThriftClientRequest}
import com.twitter.scrooge.{TReusableBuffer, ThriftStruct, ThriftStructCodec}
import com.twitter.util.{Future, Return, Throw, Throwables}
import java.nio.ByteBuffer
import java.util.Arrays
import org.apache.thrift.protocol._
import org.apache.thrift.TApplicationException
import org.apache.thrift.transport.TMemoryInputTransport
import scala.collection.{Map, Set}
import scala.language.higherKinds


@javax.annotation.Generated(value = Array("com.twitter.scrooge.Compiler"))
class RealSenseService$FinagleClient(
    val service: com.twitter.finagle.Service[ThriftClientRequest, Array[Byte]],
    val clientParam: RichClientParam)
  extends RealSenseService[Future] {

  @deprecated("Use com.twitter.finagle.thrift.RichClientParam", "2017-08-16")
  def this(
    service: com.twitter.finagle.Service[ThriftClientRequest, Array[Byte]],
    protocolFactory: TProtocolFactory = Protocols.binaryFactory(),
    serviceName: String = "RealSenseService",
    stats: StatsReceiver = NullStatsReceiver,
    responseClassifier: ctfs.ResponseClassifier = ctfs.ResponseClassifier.Default
  ) = this(
    service,
    RichClientParam(
      protocolFactory,
      serviceName,
      clientStats = stats,
      responseClassifier = responseClassifier
    )
  )

  @deprecated("Use com.twitter.finagle.thrift.RichClientParam", "2017-08-16")
  def this(
    service: com.twitter.finagle.Service[ThriftClientRequest, Array[Byte]],
    protocolFactory: TProtocolFactory,
    serviceName: String,
    stats: StatsReceiver
  ) = this(service, protocolFactory, serviceName, stats, ctfs.ResponseClassifier.Default)

  import RealSenseService._

  def serviceName: String = clientParam.serviceName

  override def asClosable: _root_.com.twitter.util.Closable = service

  private[this] def protocolFactory: TProtocolFactory = clientParam.restrictedProtocolFactory
  private[this] def maxReusableBufferSize: Int = clientParam.maxThriftBufferSize

  private[this] val tlReusableBuffer = TReusableBuffer(maxThriftBufferSize = maxReusableBufferSize)

  protected def encodeRequest(name: String, args: ThriftStruct) = {
    val memoryBuffer = tlReusableBuffer.get()
    try {
      val oprot = protocolFactory.getProtocol(memoryBuffer)

      oprot.writeMessageBegin(new TMessage(name, TMessageType.CALL, 0))
      args.write(oprot)
      oprot.writeMessageEnd()
      oprot.getTransport().flush()
      val bytes = Arrays.copyOfRange(memoryBuffer.getArray(), 0, memoryBuffer.length())
      new ThriftClientRequest(bytes, false)
    } finally {
      tlReusableBuffer.reset()
    }
  }

  protected def decodeResponse[T <: ThriftStruct](resBytes: Array[Byte], codec: ThriftStructCodec[T]) = {
    val iprot = protocolFactory.getProtocol(new TMemoryInputTransport(resBytes))
    val msg = iprot.readMessageBegin()
    try {
      if (msg.`type` == TMessageType.EXCEPTION) {
        val exception = TApplicationException.readFrom(iprot) match {
          case sourced: SourcedException =>
            if (serviceName != "") sourced.serviceName = serviceName
            sourced
          case e => e
        }
        throw exception
      } else {
        codec.decode(iprot)
      }
    } finally {
      iprot.readMessageEnd()
    }
  }

  protected def missingResult(name: String) = {
    new TApplicationException(
      TApplicationException.MISSING_RESULT,
      name + " failed: unknown result"
    )
  }

  protected def setServiceName(ex: Throwable): Throwable =
    if (this.serviceName == "") ex
    else {
      ex match {
        case se: SourcedException =>
          se.serviceName = this.serviceName
          se
        case _ => ex
      }
    }

  // ----- end boilerplate.

  private[this] def stats: StatsReceiver = clientParam.clientStats
  private[this] def responseClassifier: ctfs.ResponseClassifier = clientParam.responseClassifier

  private[this] val scopedStats = if (serviceName != "") stats.scope(serviceName) else stats
  private[this] object __stats_capture {
    val RequestsCounter = scopedStats.scope("capture").counter("requests")
    val SuccessCounter = scopedStats.scope("capture").counter("success")
    val FailuresCounter = scopedStats.scope("capture").counter("failures")
    val FailuresScope = scopedStats.scope("capture").scope("failures")
  }
  val captureRealSenseServiceReplyDeserializer: Array[Byte] => _root_.com.twitter.util.Try[ch.unibas.cs.gravis.realsense.CaptureResult] = {
    response: Array[Byte] => {
      val result = decodeResponse(response, Capture.Result)
  
      result.firstException() match {
        case Some(exception) => _root_.com.twitter.util.Throw(setServiceName(exception))
        case _ => result.successField match {
          case Some(success) => _root_.com.twitter.util.Return(success)
          case _ => _root_.com.twitter.util.Throw(missingResult("capture"))
        }
      }
    }
  }
  
  def capture(): Future[ch.unibas.cs.gravis.realsense.CaptureResult] = {
    __stats_capture.RequestsCounter.incr()
    val inputArgs = Capture.Args()
  
    val serdeCtx = new _root_.com.twitter.finagle.thrift.DeserializeCtx[ch.unibas.cs.gravis.realsense.CaptureResult](inputArgs, captureRealSenseServiceReplyDeserializer)
    _root_.com.twitter.finagle.context.Contexts.local.let(
      _root_.com.twitter.finagle.thrift.DeserializeCtx.Key,
      serdeCtx,
      _root_.com.twitter.finagle.thrift.Headers.Request.Key,
      _root_.com.twitter.finagle.thrift.Headers.Request.newValues
    ) {
      val serialized = encodeRequest("capture", inputArgs)
      this.service(serialized).flatMap { response =>
        Future.const(serdeCtx.deserialize(response))
      }.respond { response =>
        val responseClass = responseClassifier.applyOrElse(
          ctfs.ReqRep(inputArgs, response),
          ctfs.ResponseClassifier.Default)
        responseClass match {
          case ctfs.ResponseClass.Successful(_) =>
            __stats_capture.SuccessCounter.incr()
          case ctfs.ResponseClass.Failed(_) =>
            __stats_capture.FailuresCounter.incr()
            response match {
              case Throw(ex) =>
                setServiceName(ex)
                __stats_capture.FailuresScope.counter(Throwables.mkString(ex): _*).incr()
              case _ =>
            }
        }
      }
    }
  }
}
