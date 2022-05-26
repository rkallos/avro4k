package com.github.avrokotlin.avro4k.schema

import com.github.avrokotlin.avro4k.Avro
import com.github.avrokotlin.avro4k.AvroIsError
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import kotlinx.serialization.Serializable

class AvroIsErrorSchemaTest : FunSpec({
   test("support @AvroIsError") {
      val expected = org.apache.avro.Schema.Parser().parse(javaClass.getResourceAsStream("/error_type.json"))
      val schema = Avro.default.schema(Error.serializer())
      schema.toString(true) shouldBe expected.toString(true)
   }
}) {
   @Serializable
   @AvroIsError
   data class Error(val code: Int, val reason: String)
}