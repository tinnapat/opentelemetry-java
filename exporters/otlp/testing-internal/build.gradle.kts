plugins {
  id("otel.java-conventions")
}

description = "OpenTelemetry Exporter Testing (Internal)"
otelJava.moduleName.set("io.opentelemetry.exporter.otlp.testing.internal")

dependencies {
  api(project(":exporters:otlp:common"))
  api(project(":sdk:logs"))
  api(project(":sdk:metrics"))
  api(project(":sdk:trace"))
  api(project(":sdk:testing"))
  api(project(":sdk:logs-testing"))

  api(project(":exporters:otlp:all"))
  api(project(":exporters:otlp:logs"))

  // Must be compileOnly so gRPC isn't on the classpath for non-gRPC tests.
  compileOnly("io.grpc:grpc-stub")

  implementation(project(":testing-internal"))

  api("io.opentelemetry.proto:opentelemetry-proto")
  api("org.junit.jupiter:junit-jupiter-api")
  implementation("com.squareup.okhttp3:okhttp")
  implementation("org.junit.jupiter:junit-jupiter-params")

  implementation("com.linecorp.armeria:armeria-grpc-protocol")
  implementation("com.linecorp.armeria:armeria-junit5")
  implementation("io.github.netmikey.logunit:logunit-jul")
  implementation("org.assertj:assertj-core")
}
