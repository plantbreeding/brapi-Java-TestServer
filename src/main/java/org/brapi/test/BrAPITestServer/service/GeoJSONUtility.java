package org.brapi.test.BrAPITestServer.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.brapi.test.BrAPITestServer.model.entity.CoordinateEntity;
import org.brapi.test.BrAPITestServer.model.entity.GeoJSONEntity;

import io.swagger.model.GeoJSON;
import io.swagger.model.LinearRing;
import io.swagger.model.PointGeometry;
import io.swagger.model.Polygon;
import io.swagger.model.PolygonGeometry;
import io.swagger.model.Position;

public class GeoJSONUtility {
	public final static String POINT = "Point";
	public final static String POLYGON = "Polygon";

	public static GeoJSONEntity convertToEntity(GeoJSON geojson) {
		GeoJSONEntity entity = new GeoJSONEntity();
		if (geojson.getGeometry() instanceof PointGeometry) {
			entity.setType(POINT);
			Position point = ((PointGeometry) geojson.getGeometry()).getCoordinates();
			CoordinateEntity pointEntity = convertToEntiy(entity, point);
			entity.addCoordinate(pointEntity);
		} else if (geojson.getGeometry() instanceof PolygonGeometry) {
			entity.setType(POLYGON);
			// Only handles single polygons, most plots are rectangles
			Polygon polygon = ((PolygonGeometry) geojson.getGeometry()).getCoordinates();
			LinearRing ring = polygon.get(0);
			for (Position point : ring) {
				CoordinateEntity pointEntity = convertToEntiy(entity, point);
				entity.addCoordinate(pointEntity);
			}
		}
		return entity;
	}

	private  static CoordinateEntity convertToEntiy(GeoJSONEntity entity, Position pointArray) {
		CoordinateEntity pointEntity = new CoordinateEntity();
		pointEntity.setLatitude(pointArray.get(0));
		pointEntity.setLongitude(pointArray.get(1));
		if (pointArray.size() >= 3) {
			pointEntity.setAltitude(pointArray.get(2));
		}
		pointEntity.setGeoJSON(entity);

		return pointEntity;
	}

	public static GeoJSON convertFromEntity(GeoJSONEntity entity) {
		GeoJSON geojson = null;
		if (entity != null) {
			geojson = new GeoJSON();
			if (POINT.equals(entity.getType())) {
				PointGeometry geometry = new PointGeometry();
				geometry.setCoordinates(convertFromEntity(entity.getCoordinates().get(0)));
				geojson.setGeometry(geometry);
			} else if (POLYGON.equals(entity.getType())) {
				LinearRing ring = new LinearRing();
				for (CoordinateEntity pointEntity : entity.getCoordinates()) {
					ring.add(convertFromEntity(pointEntity));
				}
				Polygon polygon = new Polygon();
				polygon.add(ring);
				PolygonGeometry geometry = new PolygonGeometry();
				geometry.setCoordinates(polygon);
				geojson.setGeometry(geometry);
			}
		}
		return geojson;
	}

	private static Position convertFromEntity(CoordinateEntity entity) {
		Position point = new Position();
		point.add(entity.getLatitude());
		point.add(entity.getLongitude());
		if (entity.getAltitude() != null) {
			point.add(entity.getAltitude());
		}
		return point;
	}

	public static BigDecimal getLat(GeoJSONEntity entity) {
		BigDecimal avg = BigDecimal.ZERO;
		if (entity != null && entity.getCoordinates() != null && entity.getCoordinates().size() > 0) {
			if (POINT.equals(entity.getType())) {
				avg = entity.getCoordinates().get(0).getLatitude();
			} else if (POLYGON.equals(entity.getType())) {
				for(CoordinateEntity coord: entity.getCoordinates()) {
					avg = avg.add(coord.getLatitude());
				}
				avg = avg.divide(new BigDecimal(entity.getCoordinates().size()));
			}
		}
		return avg;
	}
	
	public static String getDegreesStr(BigDecimal signedValue) {
		BigDecimal sixty = new BigDecimal(60);
		BigDecimal sign = new BigDecimal(signedValue.signum());
		BigDecimal value = signedValue.abs();
		BigDecimal degrees = value.setScale(0, RoundingMode.FLOOR);
		BigDecimal minutes = value.subtract(degrees).multiply(sixty).setScale(0, RoundingMode.FLOOR);
		BigDecimal seconds = value.subtract(degrees).multiply(sixty).subtract(minutes).multiply(sixty).setScale(3, RoundingMode.FLOOR);
		return degrees.multiply(sign).toPlainString() + " " + minutes.toPlainString() + "' " + seconds.toPlainString() + "\"";
	}

	public static BigDecimal getLon(GeoJSONEntity entity) {
		BigDecimal avg = BigDecimal.ZERO;
		if (entity != null && entity.getCoordinates() != null && entity.getCoordinates().size() > 0) {
			if (POINT.equals(entity.getType())) {
				avg = entity.getCoordinates().get(0).getLongitude();
			} else if (POLYGON.equals(entity.getType())) {
				for(CoordinateEntity coord: entity.getCoordinates()) {
					avg = avg.add(coord.getLongitude());
				}
				avg = avg.divide(new BigDecimal(entity.getCoordinates().size()));
			}
		}
		return avg;
	}

	public static BigDecimal getElv(GeoJSONEntity entity) {
		BigDecimal avg = BigDecimal.ZERO;
		if (entity != null && entity.getCoordinates() != null && entity.getCoordinates().size() > 0) {
			if (POINT.equals(entity.getType())) {
				avg = entity.getCoordinates().get(0).getAltitude();
			} else if (POLYGON.equals(entity.getType())) {
				for(CoordinateEntity coord: entity.getCoordinates()) {
					avg = avg.add(coord.getAltitude());
				}
				avg = avg.divide(new BigDecimal(entity.getCoordinates().size()));
			}
		}
		return avg;
	}
}
