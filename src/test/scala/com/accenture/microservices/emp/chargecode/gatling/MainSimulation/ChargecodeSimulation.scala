package com.accenture.microservices.emp.chargecode.gatling.MainSimulation;

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class MainSimulation extends Simulation {
 
  val httpConf = http.baseURL("http://localhost:8090") // Here is the root for all relative URLs
 
  val scn = scenario("Sample")
    .exec(http("request1").get("/chargecodes/AAAAA?access_token=eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6WyJvcGVuaWQiXSwiZXhwIjoxNTAyNzgyMjY1LCJqdGkiOiIyYmEwMzc1Yi03NGQzLTQyZGYtOTVjNy02YjhlYjMxZWE2MTMiLCJjbGllbnRfaWQiOiJpbnRlcm5hbCJ9.Gpa9PFl7lsWu76pcq17ILOx3-Yv1Lh32pkVWoxegtH85f10-qj_zOsZn7_GYA2Nka-lGPMFcb70-hIbDAC1BrEWj9ZhjWJjbT6y4_gb8oL-E7Llof9pnk6ytMlowq9Y5tWovwF6IjLUpFD4sVIeYeNcXYOlwX-3qTxhStjZYHLtT1uKZx_IpwQOHleOwiREpCaUkt38CgZfr-A4JyZhPM7UUzJExsEYsqmHJdAZh_RgHB1ojNvnKdVr7jfM7OWrqrzbNNMUWIKUO8taZoWDRHi7V3Qfh3QrWcIabWDwsh6sUOPmJ_iaVPBwmcTohkWlUVYLl35no7yRlEX-kNW5hig")).pause(100 milliseconds)
    .exec(http("request1").get("/chargecodes/AAAAA/employees/1233?access_token=eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6WyJvcGVuaWQiXSwiZXhwIjoxNTAyNzgyMjY1LCJqdGkiOiIyYmEwMzc1Yi03NGQzLTQyZGYtOTVjNy02YjhlYjMxZWE2MTMiLCJjbGllbnRfaWQiOiJpbnRlcm5hbCJ9.Gpa9PFl7lsWu76pcq17ILOx3-Yv1Lh32pkVWoxegtH85f10-qj_zOsZn7_GYA2Nka-lGPMFcb70-hIbDAC1BrEWj9ZhjWJjbT6y4_gb8oL-E7Llof9pnk6ytMlowq9Y5tWovwF6IjLUpFD4sVIeYeNcXYOlwX-3qTxhStjZYHLtT1uKZx_IpwQOHleOwiREpCaUkt38CgZfr-A4JyZhPM7UUzJExsEYsqmHJdAZh_RgHB1ojNvnKdVr7jfM7OWrqrzbNNMUWIKUO8taZoWDRHi7V3Qfh3QrWcIabWDwsh6sUOPmJ_iaVPBwmcTohkWlUVYLl35no7yRlEX-kNW5hig")).pause(100 milliseconds)
    
  setUp(scn.inject(rampUsers(20) over(5 seconds)) .protocols(httpConf))
}