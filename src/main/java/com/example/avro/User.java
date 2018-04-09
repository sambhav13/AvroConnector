/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.example.avro;  
@SuppressWarnings("all")
/** This is a user record in a fictitious to-do-list management app. It supports arbitrary grouping and nesting of items, and allows you to add items by email or by tweeting.

Note this app doesn't actually exist. The schema is just a demo for [Avrodoc](https://github.com/ept/avrodoc)! */
@org.apache.avro.specific.AvroGenerated
public class User extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"User\",\"namespace\":\"com.example.avro\",\"doc\":\"This is a user record in a fictitious to-do-list management app. It supports arbitrary grouping and nesting of items, and allows you to add items by email or by tweeting.\\n\\nNote this app doesn't actually exist. The schema is just a demo for [Avrodoc](https://github.com/ept/avrodoc)!\",\"fields\":[{\"name\":\"id\",\"type\":\"int\",\"doc\":\"System-assigned numeric user ID. Cannot be changed by the user.\"},{\"name\":\"username\",\"type\":\"string\",\"doc\":\"The username chosen by the user. Can be changed by the user.\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  /** System-assigned numeric user ID. Cannot be changed by the user. */
  @Deprecated public int id;
  /** The username chosen by the user. Can be changed by the user. */
  @Deprecated public java.lang.CharSequence username;

  /**
   * Default constructor.
   */
  public User() {}

  /**
   * All-args constructor.
   */
  public User(java.lang.Integer id, java.lang.CharSequence username) {
    this.id = id;
    this.username = username;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return username;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.Integer)value$; break;
    case 1: username = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'id' field.
   * System-assigned numeric user ID. Cannot be changed by the user.   */
  public java.lang.Integer getId() {
    return id;
  }

  /**
   * Sets the value of the 'id' field.
   * System-assigned numeric user ID. Cannot be changed by the user.   * @param value the value to set.
   */
  public void setId(java.lang.Integer value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'username' field.
   * The username chosen by the user. Can be changed by the user.   */
  public java.lang.CharSequence getUsername() {
    return username;
  }

  /**
   * Sets the value of the 'username' field.
   * The username chosen by the user. Can be changed by the user.   * @param value the value to set.
   */
  public void setUsername(java.lang.CharSequence value) {
    this.username = value;
  }

  /** Creates a new User RecordBuilder */
  public static com.example.avro.User.Builder newBuilder() {
    return new com.example.avro.User.Builder();
  }
  
  /** Creates a new User RecordBuilder by copying an existing Builder */
  public static com.example.avro.User.Builder newBuilder(com.example.avro.User.Builder other) {
    return new com.example.avro.User.Builder(other);
  }
  
  /** Creates a new User RecordBuilder by copying an existing User instance */
  public static com.example.avro.User.Builder newBuilder(com.example.avro.User other) {
    return new com.example.avro.User.Builder(other);
  }
  
  /**
   * RecordBuilder for User instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<User>
    implements org.apache.avro.data.RecordBuilder<User> {

    private int id;
    private java.lang.CharSequence username;

    /** Creates a new Builder */
    private Builder() {
      super(com.example.avro.User.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.example.avro.User.Builder other) {
      super(other);
    }
    
    /** Creates a Builder by copying an existing User instance */
    private Builder(com.example.avro.User other) {
            super(com.example.avro.User.SCHEMA$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.username)) {
        this.username = data().deepCopy(fields()[1].schema(), other.username);
        fieldSetFlags()[1] = true;
      }
    }

    /** Gets the value of the 'id' field */
    public java.lang.Integer getId() {
      return id;
    }
    
    /** Sets the value of the 'id' field */
    public com.example.avro.User.Builder setId(int value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'id' field has been set */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'id' field */
    public com.example.avro.User.Builder clearId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'username' field */
    public java.lang.CharSequence getUsername() {
      return username;
    }
    
    /** Sets the value of the 'username' field */
    public com.example.avro.User.Builder setUsername(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.username = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'username' field has been set */
    public boolean hasUsername() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'username' field */
    public com.example.avro.User.Builder clearUsername() {
      username = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public User build() {
      try {
        User record = new User();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.Integer) defaultValue(fields()[0]);
        record.username = fieldSetFlags()[1] ? this.username : (java.lang.CharSequence) defaultValue(fields()[1]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}