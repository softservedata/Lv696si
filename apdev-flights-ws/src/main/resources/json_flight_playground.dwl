%dw 2.0
output application/xml
---
data: {
	hub: "MUA",
	flight @(airline: payload.airline): {
	code: payload.toAirportCode,
	}
}