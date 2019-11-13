/**
 * Generated by Scrooge
 *   version: 18.4.0
 *   rev: b64bcb47af2451b2e51a1ed1b3876f6c06c642b3
 *   built at: 20180410-144039
 */
package ch.unibas.cs.gravis.realsense

import com.twitter.finagle.{
  service => ctfs,
  Filter => finagle$Filter,
  Service => finagle$Service,
  thrift => _,
  _
}
import com.twitter.finagle.stats.{Counter, NullStatsReceiver, StatsReceiver}
import com.twitter.finagle.thrift.RichServerParam
import com.twitter.io.Buf
import com.twitter.scrooge._
import com.twitter.util.{Future, Return, Throw, Throwables}
import java.nio.ByteBuffer
import java.util.Arrays
import org.apache.thrift.protocol._
import org.apache.thrift.TApplicationException
import org.apache.thrift.transport.TMemoryInputTransport
import scala.collection.mutable.{
  ArrayBuffer => mutable$ArrayBuffer, HashMap => mutable$HashMap}
import scala.collection.{Map, Set}

import scala.language.higherKinds


@javax.annotation.Generated(value = Array("com.twitter.scrooge.Compiler"))
class RealSenseService$FinagleService(
  iface: RealSenseService[Future],
  serverParam: RichServerParam
) extends com.twitter.finagle.Service[Array[Byte], Array[Byte]] {
  import RealSenseService._

  @deprecated("Use com.twitter.finagle.thrift.RichServerParam", "2017-08-16")
  def this(
    iface: RealSenseService[Future],
    protocolFactory: TProtocolFactory,
    stats: StatsReceiver = NullStatsReceiver,
    maxThriftBufferSize: Int = Thrift.param.maxThriftBufferSize,
    serviceName: String = "RealSenseService"
  ) = this(iface, RichServerParam(protocolFactory, serviceName, maxThriftBufferSize, stats))

  @deprecated("Use com.twitter.finagle.thrift.RichServerParam", "2017-08-16")
  def this(
    iface: RealSenseService[Future],
    protocolFactory: TProtocolFactory,
    stats: StatsReceiver,
    maxThriftBufferSize: Int
  ) = this(iface, protocolFactory, stats, maxThriftBufferSize, "RealSenseService")

  @deprecated("Use com.twitter.finagle.thrift.RichServerParam", "2017-08-16")
  def this(
    iface: RealSenseService[Future],
    protocolFactory: TProtocolFactory
  ) = this(iface, protocolFactory, NullStatsReceiver, Thrift.param.maxThriftBufferSize)

  def serviceName: String = serverParam.serviceName
  private[this] def responseClassifier: ctfs.ResponseClassifier = serverParam.responseClassifier
  private[this] def stats: StatsReceiver = serverParam.serverStats

  private[this] def protocolFactory: TProtocolFactory = serverParam.restrictedProtocolFactory
  private[this] def maxReusableBufferSize: Int = serverParam.maxThriftBufferSize

  private[this] val tlReusableBuffer = TReusableBuffer(maxThriftBufferSize = maxReusableBufferSize)

  protected val serviceMap = new mutable$HashMap[String, finagle$Service[(TProtocol, Int), Array[Byte]]]()

  protected def addService(name: String, service: finagle$Service[(TProtocol, Int), Array[Byte]]): Unit = {
    serviceMap(name) = service
  }

  final protected def exception(name: String, seqid: Int, code: Int, message: String): Buf = {
    val x = new TApplicationException(code, message)
    val memoryBuffer = tlReusableBuffer.get()
    try {
      val oprot = protocolFactory.getProtocol(memoryBuffer)

      oprot.writeMessageBegin(new TMessage(name, TMessageType.EXCEPTION, seqid))
      x.write(oprot)
      oprot.writeMessageEnd()
      oprot.getTransport().flush()

      // make a copy of the array of bytes to construct a new buffer because memoryBuffer is reusable
      Buf.ByteArray.Shared(memoryBuffer.getArray(), 0, memoryBuffer.length())
    } finally {
      tlReusableBuffer.reset()
    }
  }

  final protected def reply(name: String, seqid: Int, result: ThriftStruct): Buf = {
    val memoryBuffer = tlReusableBuffer.get()
    try {
      val oprot = protocolFactory.getProtocol(memoryBuffer)

      oprot.writeMessageBegin(new TMessage(name, TMessageType.REPLY, seqid))
      result.write(oprot)
      oprot.writeMessageEnd()
      oprot.getTransport().flush()

      // make a copy of the array of bytes to construct a new buffer because memoryBuffer is reusable
      Buf.ByteArray.Shared(memoryBuffer.getArray(), 0, memoryBuffer.length())
    } finally {
      tlReusableBuffer.reset()
    }
  }

  final def apply(request: Array[Byte]): Future[Array[Byte]] = {
    val inputTransport = new TMemoryInputTransport(request)
    val iprot = protocolFactory.getProtocol(inputTransport)

    try {
      val msg = iprot.readMessageBegin()
      val service = serviceMap.get(msg.name)
      service match {
        case _root_.scala.Some(svc) =>
          svc(iprot, msg.seqid)
        case _ =>
          TProtocolUtil.skip(iprot, TType.STRUCT)
          Future.value(Buf.ByteArray.Owned.extract(
            exception(msg.name, msg.seqid, TApplicationException.UNKNOWN_METHOD,
              "Invalid method name: '" + msg.name + "'")))
      }
    } catch {
      case e: Exception => Future.exception(e)
    }
  }

  private object ThriftMethodStats {
    def apply(stats: StatsReceiver): ThriftMethodStats =
      ThriftMethodStats(
        stats.counter("requests"),
        stats.counter("success"),
        stats.counter("failures"),
        stats.scope("failures")
      )
  }

  private case class ThriftMethodStats(
    requestsCounter: Counter,
    successCounter: Counter,
    failuresCounter: Counter,
    failuresScope: StatsReceiver
  )

  private def missingResult(name: String): TApplicationException = {
    new TApplicationException(
      TApplicationException.MISSING_RESULT,
      name + " failed: unknown result"
    )
  }

  private def setServiceName(ex: Throwable): Throwable =
    if (this.serviceName == "") ex
    else {
      ex match {
        case se: SourcedException =>
          se.serviceName = this.serviceName
          se
        case _ => ex
      }
    }

  private def recordResponse(reqRep: ctfs.ReqRep, methodStats: ThriftMethodStats): Unit = {
    val responseClass = responseClassifier.applyOrElse(reqRep, ctfs.ResponseClassifier.Default)
    responseClass match {
      case ctfs.ResponseClass.Successful(_) =>
        methodStats.successCounter.incr()
      case ctfs.ResponseClass.Failed(_) =>
        methodStats.failuresCounter.incr()
        reqRep.response match {
          case Throw(ex) =>
            methodStats.failuresScope.counter(Throwables.mkString(ex): _*).incr()
          case _ =>
        }
    }
  }

  final protected def perMethodStatsFilter(
    method: ThriftMethod
  ): finagle$Filter[(TProtocol, Int), Array[Byte], (TProtocol, Int), RichResponse[method.Args, method.Result]] = {
    val methodStats = ThriftMethodStats((if (serviceName != "") stats.scope(serviceName) else stats).scope(method.name))
    new finagle$Filter[(TProtocol, Int), Array[Byte], (TProtocol, Int), RichResponse[method.Args, method.Result]] {
      def apply(
        req: (TProtocol, Int),
        service: finagle$Service[(TProtocol, Int), RichResponse[method.Args, method.Result]]
      ): Future[Array[Byte]] = {
        methodStats.requestsCounter.incr()
        service(req).transform {
          case Return(value) =>
            value match {
              case SuccessfulResponse(req, _, result) =>
                recordResponse(ctfs.ReqRep(req, _root_.com.twitter.util.Return(result.successField.get)), methodStats)
              case ProtocolExceptionResponse(req, _, exp) =>
                recordResponse(ctfs.ReqRep(req, _root_.com.twitter.util.Throw(exp)), methodStats)
              case ThriftExceptionResponse(req, _, ex) =>
                val rep = ex match {
                  case exp: ThriftException => setServiceName(exp)
                  case _ => missingResult(serviceName)
                }
                recordResponse(ctfs.ReqRep(req, _root_.com.twitter.util.Throw(rep)), methodStats)
            }
            Future.value(Buf.ByteArray.Owned.extract(value.response))
          case t @ Throw(_) =>
            recordResponse(ctfs.ReqRep(req, t), methodStats)
            Future.const(t.cast[Array[Byte]])
        }
      }
    }
  }
  // ---- end boilerplate.

  addService("capture", {
    val statsFilter: finagle$Filter[(TProtocol, Int), Array[Byte], (TProtocol, Int), RichResponse[Capture.Args, Capture.Result]] = perMethodStatsFilter(Capture)
  
    val methodService = new finagle$Service[Capture.Args, Capture.SuccessType] {
      def apply(args: Capture.Args): Future[Capture.SuccessType] = {
        if (_root_.com.twitter.finagle.tracing.Trace.isActivelyTracing) {
          _root_.com.twitter.finagle.tracing.Trace.recordRpc("capture")
        }
        iface.capture()
      }
    }
  
    val protocolExnFilter = new SimpleFilter[(TProtocol, Int), RichResponse[Capture.Args, Capture.Result]] {
      def apply(
        request: (TProtocol, Int),
        service: finagle$Service[(TProtocol, Int), RichResponse[Capture.Args, Capture.Result]]
      ): Future[RichResponse[Capture.Args, Capture.Result]] = {
        val iprot = request._1
        val seqid = request._2
        val res = service(request)
        res.transform {
          case _root_.com.twitter.util.Throw(e: TProtocolException) =>
            iprot.readMessageEnd()
            Future.value(
              ProtocolExceptionResponse(
                null,
                exception("capture", seqid, TApplicationException.PROTOCOL_ERROR, e.getMessage),
                new TApplicationException(TApplicationException.PROTOCOL_ERROR, e.getMessage)))
          case _ =>
            res
        }
      }
    }
  
    val serdeFilter = new finagle$Filter[(TProtocol, Int), RichResponse[Capture.Args, Capture.Result], Capture.Args, Capture.SuccessType] {
      def apply(
        request: (TProtocol, Int),
        service: finagle$Service[Capture.Args, Capture.SuccessType]
      ): Future[RichResponse[Capture.Args, Capture.Result]] = {
        val iprot = request._1
        val seqid = request._2
        val args = Capture.Args.decode(iprot)
        iprot.readMessageEnd()
        val res = service(args)
        res.transform {
          case _root_.com.twitter.util.Return(value) =>
            val methodResult = Capture.Result(success = Some(value))
            Future.value(
              SuccessfulResponse(
                args,
                reply("capture", seqid, methodResult),
                methodResult))
          case _root_.com.twitter.util.Throw(e: ch.unibas.cs.gravis.realsense.ThriftServerError) => {
            Future.value(
              ThriftExceptionResponse(
                args,
                reply("capture", seqid, Capture.Result(error = Some(e))),
                e))
          }
          case t @ _root_.com.twitter.util.Throw(_) =>
            Future.const(t.cast[RichResponse[Capture.Args, Capture.Result]])
        }
      }
    }
  
    statsFilter.andThen(protocolExnFilter).andThen(serdeFilter).andThen(methodService)
  })
}
