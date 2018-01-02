package com.zandolsi.examples.ms.establishment.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Patch<T> {

  private static final Logger LOGGER = LoggerFactory.getLogger(Patch.class);
  private Class<T> type;

  private Patch(Class<T> type) {
    this.type = type;
  }

  public static <T> Patch<T> of(Class<T> type) {
    return new Patch<>(type);
  }

  public T patch(T objectToPatch, JsonPatch jsonPatch) {
    try {
      ObjectMapper mapper = new ObjectMapper();
      mapper.registerModule(new JodaModule());
      JsonNode patchedNode = jsonPatch.apply(mapper.convertValue(objectToPatch, JsonNode.class));
      return mapper.treeToValue(patchedNode, type);
    } catch (IOException e) {
      LOGGER.error("error occurred when trying to create patch from json node", e);
      throw new IllegalArgumentException("Can not create patch from json node");
    } catch (JsonPatchException e) {
      LOGGER.error("error occurred when trying to patch object", e);
      throw new IllegalArgumentException("Can not create patch object");
    }
  }
}
