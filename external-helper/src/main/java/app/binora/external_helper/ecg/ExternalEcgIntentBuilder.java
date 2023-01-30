package app.binora.external_helper.ecg;

import android.content.Intent;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import app.binora.external_extras.ExternalActions;
import app.binora.external_extras.ExternalExtras;
import app.binora.external_helper.enums.EcgAmplitudeScale;
import app.binora.external_helper.enums.EcgMode;
import app.binora.external_helper.enums.Gender;
import app.binora.external_helper.enums.HeightUnit;
import app.binora.external_helper.enums.Language;
import app.binora.external_helper.enums.PowerLineFilter;
import app.binora.external_helper.enums.ReportGridColor;
import app.binora.external_helper.enums.EcgTimeScale;
import app.binora.external_helper.enums.SensorConfig;
import app.binora.external_helper.enums.Theme;
import app.binora.external_helper.enums.WeightUnit;

public class ExternalEcgIntentBuilder {

    private final Intent intent;

    public ExternalEcgIntentBuilder() {
        intent = new Intent(ExternalActions.GET_ECG_ACTION);
    }

    public ExternalEcgIntentBuilder setMode(@NonNull EcgMode mode) {
        String option;
        switch (mode) {
            case HUMAN:
                option = ExternalExtras.HUMAN_MODE_EXTRA_VALUE;
                break;
            case INTERNAL_TEST:
                option = ExternalExtras.INTERNAL_TEST_MODE_EXTRA_VALUE;
                break;
            case SIMULATOR:
                option = ExternalExtras.SIMULATOR_MODE_EXTRA_VALUE;
                break;
            default:
                throw new IllegalArgumentException();
        }
        intent.putExtra(ExternalExtras.EXTRA_ECG_MODE, option);
        return this;
    }

    public ExternalEcgIntentBuilder setSensorConfig(@NonNull SensorConfig config) {
        String option;
        switch (config) {
            case WILSON:
                option = ExternalExtras.SENSOR_CONFIG_WILSON_EXTRA_VALUE;
                break;
            case EASI:
                option = ExternalExtras.SENSOR_CONFIG_EASI_EXTRA_VALUE;
                break;
            default:
                throw new IllegalArgumentException();
        }
        intent.putExtra(ExternalExtras.EXTRA_ECG_SENSOR_CONFIG, option);
        return this;
    }

    public ExternalEcgIntentBuilder setPowerLineFilter(@NonNull PowerLineFilter filter) {
        String option;
        switch (filter) {
            case NONE:
                option = ExternalExtras.POWER_LINE_FILTER_NONE_EXTRA_VALUE;
                break;
            case HZ_50:
                option = ExternalExtras.POWER_LINE_FILTER_50_HZ_EXTRA_VALUE;
                break;
            case HZ_60:
                option = ExternalExtras.POWER_LINE_FILTER_60_HZ_EXTRA_VALUE;
                break;
            default:
                throw new IllegalArgumentException();
        }
        intent.putExtra(ExternalExtras.EXTRA_ECG_POWER_LINE_FILTER, option);
        return this;
    }

    public ExternalEcgIntentBuilder setSoundState(boolean isOn) {
        intent.putExtra(ExternalExtras.EXTRA_SOUND_STATE, isOn);
        return this;
    }

    public ExternalEcgIntentBuilder setSoundOn() {
        intent.putExtra(ExternalExtras.EXTRA_SOUND_STATE, true);
        return this;
    }

    public ExternalEcgIntentBuilder setSoundOff() {
        intent.putExtra(ExternalExtras.EXTRA_SOUND_STATE, false);
        return this;
    }

    public ExternalEcgIntentBuilder setVolume(@IntRange(from = 0, to = 100) int volume) {
        intent.putExtra(ExternalExtras.EXTRA_VOLUME, Math.min(100, Math.max(volume, 0)));
        return this;
    }

    public ExternalEcgIntentBuilder setDuration(@IntRange(from = 10, to = 60) int duration) {
        intent.putExtra(ExternalExtras.EXTRA_MAX_DURATION, Math.min(100, Math.max(duration, 10)));
        return this;
    }

    public ExternalEcgIntentBuilder setAmplitudeScale(@NonNull EcgAmplitudeScale amplitudeScale) {
        String option;
        switch (amplitudeScale) {
            case AMPLITUDE_2_5_MM_TO_MV:
                option = ExternalExtras.SCALE_SMALL_EXTRA_VALUE;
                break;
            case AMPLITUDE_5_0_MM_TO_MV:
                option = ExternalExtras.SCALE_MEDIUM_EXTRA_VALUE;
                break;
            case AMPLITUDE_10_0_MM_TO_MV:
                option = ExternalExtras.SCALE_LARGE_EXTRA_VALUE;
                break;
            default:
                throw new IllegalArgumentException();
        }
        intent.putExtra(ExternalExtras.EXTRA_AMPLITUDE_SCALE, option);
        return this;
    }

    public ExternalEcgIntentBuilder setTimeScale(@NonNull EcgTimeScale timeScale) {
        String option;
        switch (timeScale) {
            case TIME_12_5_MM_TO_S:
                option = ExternalExtras.SCALE_SMALL_EXTRA_VALUE;
                break;
            case TIME_25_0_MM_TO_S:
                option = ExternalExtras.SCALE_LARGE_EXTRA_VALUE;
                break;
            default:
                throw new IllegalArgumentException();
        }
        intent.putExtra(ExternalExtras.EXTRA_TIME_SCALE, option);
        return this;
    }

    public ExternalEcgIntentBuilder setReportGridColor(@NonNull ReportGridColor gridColor) {
        String option;
        switch (gridColor) {
            case GREEN:
                option = ExternalExtras.REPORT_GRID_GREEN_EXTRA_VALUE;
                break;
            case BLUE:
                option = ExternalExtras.REPORT_GRID_BLUE_EXTRA_VALUE;
                break;
            case YELLOW:
                option = ExternalExtras.REPORT_GRID_YELLOW_EXTRA_VALUE;
                break;
            default:
                throw new IllegalArgumentException();
        }
        intent.putExtra(ExternalExtras.EXTRA_REPORT_GRID_COLOR, option);
        return this;
    }

    public ExternalEcgIntentBuilder setLanguage(@NonNull Language language) {
        String option;
        switch (language) {
            case ENGLISH:
                option = ExternalExtras.EN_LANGUAGE_EXTRA_VALUE;
                break;
            case RUSSIAN:
                option = ExternalExtras.RU_LANGUAGE_EXTRA_VALUE;
                break;
            case UKRAINIAN:
                option = ExternalExtras.UK_LANGUAGE_EXTRA_VALUE;
                break;
            default:
                throw new IllegalArgumentException();
        }
        intent.putExtra(ExternalExtras.EXTRA_LANGUAGE, option);
        return this;
    }

    public ExternalEcgIntentBuilder setTheme(@NonNull Theme theme) {
        String option;
        switch (theme) {
            case LIGHT:
                option = ExternalExtras.LIGHT_THEME_EXTRA_VALUE;
                break;
            case DARK:
                option = ExternalExtras.DARK_THEME_EXTRA_VALUE;
                break;
            default:
                throw new IllegalArgumentException();
        }
        intent.putExtra(ExternalExtras.EXTRA_THEME, option);
        return this;
    }

    public ExternalEcgIntentBuilder setAge(@IntRange(from = 0) int years, @IntRange(from = 0, to = 11) int months, @IntRange(from = 0, to = 31) int days) {
        intent.putExtra(ExternalExtras.EXTRA_PATIENT_AGE_YEARS, years);
        intent.putExtra(ExternalExtras.EXTRA_PATIENT_AGE_MONTHS, months);
        intent.putExtra(ExternalExtras.EXTRA_PATIENT_AGE_DAYS, days);
        return this;
    }

    public ExternalEcgIntentBuilder setGender(@NonNull Gender gender) {
        String option;
        switch (gender){
            case UNDEFINED:
                option = null;
                break;
            case MALE:
                option = ExternalExtras.MALE_GENDER_EXTRA_VALUE;
                break;
            case FEMALE:
                option = ExternalExtras.FEMALE_GENDER_EXTRA_VALUE;
                break;
            default:
                throw new IllegalArgumentException();
        }
        intent.putExtra(ExternalExtras.EXTRA_PATIENT_GENDER, option);
        return this;
    }

    public ExternalEcgIntentBuilder setHeight(@FloatRange(from = 0.0) double height, @NonNull HeightUnit heightUnit){
        String unitOption;
        switch (heightUnit){
            case CENTIMETERS:
                unitOption = ExternalExtras.CM_HEIGHT_UNITS_EXTRA_VALUE;
                break;
            case INCHES:
                unitOption = ExternalExtras.INCH_HEIGHT_UNITS_EXTRA_VALUE;
                break;
            case FEET:
                unitOption = ExternalExtras.FEET_HEIGHT_UNITS_EXTRA_VALUE;
                break;
            default:
                throw new IllegalArgumentException();
        }
        intent.putExtra(ExternalExtras.EXTRA_PATIENT_HEIGHT, height);
        intent.putExtra(ExternalExtras.EXTRA_PATIENT_HEIGHT_UNITS, unitOption);
        return this;
    }

    public ExternalEcgIntentBuilder setWeight(@FloatRange(from = 0.0) double weight, @NonNull WeightUnit weightUnit){
        String unitOption;
        switch (weightUnit){
            case GRAMS:
                unitOption = ExternalExtras.G_WEIGHT_UNITS_EXTRA_VALUE;
                break;
            case KILOGRAMS:
                unitOption = ExternalExtras.KG_WEIGHT_UNITS_EXTRA_VALUE;
                break;
            case POUNDS:
                unitOption = ExternalExtras.POUNDS_WEIGHT_UNITS_EXTRA_VALUE;
                break;
            default:
                throw new IllegalArgumentException();
        }
        intent.putExtra(ExternalExtras.EXTRA_PATIENT_WEIGHT, weight);
        intent.putExtra(ExternalExtras.EXTRA_PATIENT_WEIGHT_UNITS, unitOption);
        return this;
    }

    public ExternalEcgIntentBuilder setUserName(@Nullable String userName){
        intent.putExtra(ExternalExtras.EXTRA_USER_NAME, userName);
        return this;
    }

    public ExternalEcgIntentBuilder setClinic(@Nullable String clinic){
        intent.putExtra(ExternalExtras.EXTRA_CLINIC, clinic);
        return this;
    }

    public ExternalEcgIntentBuilder setClinicDetails(@Nullable String clinicDetails){
        intent.putExtra(ExternalExtras.EXTRA_CLINIC_DETAILS, clinicDetails);
        return this;
    }

    public ExternalEcgIntentBuilder setPatientId(@Nullable String patientId){
        intent.putExtra(ExternalExtras.EXTRA_PATIENT_ID, patientId);
        return this;
    }

    public ExternalEcgIntentBuilder setPatientName(@Nullable String patientName){
        intent.putExtra(ExternalExtras.EXTRA_PATIENT_NAME, patientName);
        return this;
    }

    public ExternalEcgIntentBuilder setPatientPhone(@Nullable String patientPhone){
        intent.putExtra(ExternalExtras.EXTRA_PATIENT_PHONE, patientPhone);
        return this;
    }

    public ExternalEcgIntentBuilder setPatientEmail(@Nullable String patientEmail){
        intent.putExtra(ExternalExtras.EXTRA_PATIENT_EMAIL, patientEmail);
        return this;
    }

    public ExternalEcgIntentBuilder setAnamnesis(@Nullable String anamnesis){
        intent.putExtra(ExternalExtras.EXTRA_ANAMNESIS, anamnesis);
        return this;
    }

    public ExternalEcgIntentBuilder setComplaints(@Nullable String complaints){
        intent.putExtra(ExternalExtras.EXTRA_COMPLAINTS, complaints);
        return this;
    }

    public ExternalEcgIntentBuilder setDrugTherapy(@Nullable String drugTherapy){
        intent.putExtra(ExternalExtras.EXTRA_DRUG_THERAPY, drugTherapy);
        return this;
    }

    public @NonNull Intent build() {
        return intent;
    }

}
