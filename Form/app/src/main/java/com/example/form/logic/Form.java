package com.example.form.logic;

public class Form {

    private String _first_name;
    private String _last_name;
    private String _street_address;
    private String _street_address2;
    private String _city;
    private String _state_province;
    private String _postal_code;
    private String _country;
    private String _email_address;
    private String _phone_number;
    private String _applying_position;
    private String _startDate;

    public Form() {
        this._first_name = "";
        this._last_name = "";
        this._street_address = "";
        this._street_address2 = "";
        this._city = "";
        this._state_province = "";
        this._postal_code = "";
        this._country = "";
        this._email_address = "";
        this._phone_number = "";
        this._applying_position = "";
        this._startDate = "";
    }

    public Form(String _first_name, String _last_name, String _street_address, String _street_address2, String _city, String _state_province, String _postal_code, String _country, String _email_address, String _phone_number, String _applying_position, String _startDate) {
        this._first_name = _first_name;
        this._last_name = _last_name;
        this._street_address = _street_address;
        this._street_address2 = _street_address2;
        this._city = _city;
        this._state_province = _state_province;
        this._postal_code = _postal_code;
        this._country = _country;
        this._email_address = _email_address;
        this._phone_number = _phone_number;
        this._applying_position = _applying_position;
        this._startDate = _startDate;
    }

    public String get_first_name() {
        return _first_name;
    }

    public void set_first_name(String _first_name) {
        this._first_name = _first_name;
    }

    public String get_last_name() {
        return _last_name;
    }

    public void set_last_name(String _last_name) {
        this._last_name = _last_name;
    }

    public String get_street_address() {
        return _street_address;
    }

    public void set_street_address(String _street_address) {
        this._street_address = _street_address;
    }

    public String get_street_address2() {
        return _street_address2;
    }

    public void set_street_address2(String _street_address2) {
        this._street_address2 = _street_address2;
    }

    public String get_city() {
        return _city;
    }

    public void set_city(String _city) {
        this._city = _city;
    }

    public String get_state_province() {
        return _state_province;
    }

    public void set_state_province(String _state_province) {
        this._state_province = _state_province;
    }

    public String get_postal_code() {
        return _postal_code;
    }

    public void set_postal_code(String _postal_code) {
        this._postal_code = _postal_code;
    }

    public String get_country() {
        return _country;
    }

    public void set_country(String _country) {
        this._country = _country;
    }

    public String get_email_address() {
        return _email_address;
    }

    public void set_email_address(String _email_address) {
        this._email_address = _email_address;
    }

    public String get_phone_number() {
        return _phone_number;
    }

    public void set_phone_number(String _phone_number) {
        this._phone_number = _phone_number;
    }

    public String get_applying_position() {
        return _applying_position;
    }

    public void set_applying_position(String _applying_position) {
        this._applying_position = _applying_position;
    }

    public String get_startDate() {
        return _startDate;
    }

    public void set_startDate(String _startDate) {
        this._startDate = _startDate;
    }

    @Override
    public String toString() {
        return "Form{" +
                "_first_name='" + _first_name + '\'' +
                ", _last_name='" + _last_name + '\'' +
                ", _street_address='" + _street_address + '\'' +
                ", _street_address2='" + _street_address2 + '\'' +
                ", _city='" + _city + '\'' +
                ", _state_province='" + _state_province + '\'' +
                ", _postal_code='" + _postal_code + '\'' +
                ", _country='" + _country + '\'' +
                ", _email_address='" + _email_address + '\'' +
                ", _phone_number='" + _phone_number + '\'' +
                ", _applying_position='" + _applying_position + '\'' +
                ", _startDate='" + _startDate + '\'' +
                '}';
    }
}
