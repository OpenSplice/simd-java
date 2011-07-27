package org.opensplice.psm.java.pub;

import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.omg.dds.core.Duration;
import org.omg.dds.core.InstanceHandle;
import org.omg.dds.core.StatusCondition;
import org.omg.dds.core.status.Status;
import org.omg.dds.pub.DataWriter;
import org.omg.dds.pub.DataWriterListener;
import org.omg.dds.pub.DataWriterQos;
import org.omg.dds.pub.Publisher;
import org.omg.dds.pub.PublisherListener;
import org.omg.dds.pub.PublisherQos;
import org.omg.dds.topic.Topic;
import org.omg.dds.topic.TopicQos;
import org.omg.dds.type.builtin.BytesDataWriter;
import org.omg.dds.type.builtin.KeyedBytes;
import org.omg.dds.type.builtin.KeyedBytesDataWriter;
import org.omg.dds.type.builtin.KeyedString;
import org.omg.dds.type.builtin.KeyedStringDataWriter;
import org.omg.dds.type.builtin.StringDataWriter;
import org.opensplice.psm.java.core.OSPLInstanceHandle;
import org.opensplice.psm.java.domain.OSPLDomainParticipant;

import DDS.LivelinessLostStatus;
import DDS.OfferedDeadlineMissedStatus;
import DDS.OfferedIncompatibleQosStatus;
import DDS.PublicationMatchedStatus;
import DDS.PublisherQosHolder;

public class OSPLPublisher implements Publisher {

    private DDS.Publisher publisher;
    private OSPLDomainParticipant participant;
    private PublisherListener listener = null;

    private class MyPublisherListener implements DDS.PublisherListener {
        private PublisherListener listener;
        private OSPLPublisher publisher;

        public MyPublisherListener(OSPLPublisher thepublisher,
                PublisherListener thelistener) {
            listener = thelistener;
            publisher = thepublisher;
        }

        @Override
        public void on_liveliness_lost(DDS.DataWriter arg0,
                LivelinessLostStatus arg1) {
            // TODO Auto-generated method stub
        }

        @Override
        public void on_offered_deadline_missed(DDS.DataWriter arg0,
                OfferedDeadlineMissedStatus arg1) {
            // TODO Auto-generated method stub

        }

        @Override
        public void on_offered_incompatible_qos(DDS.DataWriter arg0,
                OfferedIncompatibleQosStatus arg1) {
            // TODO Auto-generated method stub

        }

        @Override
        public void on_publication_matched(DDS.DataWriter arg0,
                PublicationMatchedStatus arg1) {
            // TODO Auto-generated method stub

        }

    }

    public OSPLPublisher(DDS.Publisher thepublisher,
            OSPLDomainParticipant theparticipant) {
        publisher = thepublisher;
        participant = theparticipant;
    }

    public DDS.Publisher getPublisher() {
        return publisher;
    }

    public void setListener(PublisherListener thelistener) {
        listener = thelistener;
        if (thelistener == null) {
            publisher.set_listener(null, 0);
        } else {
            MyPublisherListener mylistener = new MyPublisherListener(this,
                    thelistener);
            publisher.set_listener(mylistener, DDS.ANY_STATUS.value);
        }
    }

    public PublisherQos getQos() {
        PublisherQosHolder holder = new PublisherQosHolder();
        publisher.get_qos(holder);
        return new OSPLPublisherQos(holder.value);
    }

    @Override
    public void enable() {
        publisher.enable();
    }

    @Override
    public StatusCondition<Publisher> getStatusCondition() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public InstanceHandle getInstanceHandle() {
        return new OSPLInstanceHandle(publisher.get_instance_handle());
    }

    @Override
    public void close() {
        publisher.suspend_publications();
    }

    @Override
    public void retain() {
    }

    @Override
    public <TYPE> DataWriter<TYPE> createDataWriter(Topic<TYPE> topic) {
        DataWriter<TYPE> writer = new OSPLDataWriter<TYPE>(
                topic, this, null);
        return writer;
    }

    // public <TYPE> DataWriter<TYPE> createDataWriter(
    // Topic<TYPE> topic,
    // DataWriterQos qos,
    // DataWriterListener<TYPE> listener,
    // Collection<Class<? extends Status<?>>> statuses);

    @Override
    public <TYPE> DataWriter<TYPE> createDataWriter(Topic<TYPE> topic,
            DataWriterQos qos, DataWriterListener<TYPE> listener,
            Collection<Class<? extends Status<?>>> statuses) {
        DataWriter<TYPE> writer = new OSPLDataWriter<TYPE>(
                topic, this, qos);
        // writer.setListener(listener);
        return writer;
    }

    @Override
    public BytesDataWriter createBytesDataWriter(Topic<byte[]> topic) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public KeyedBytesDataWriter createKeyedBytesDataWriter(
            Topic<KeyedBytes> topic) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public StringDataWriter createStringDataWriter(Topic<String> topic) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public KeyedStringDataWriter createKeyedStringDataWriter(
            Topic<KeyedString> topic) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <TYPE> DataWriter<TYPE> lookupDataWriter(String topicName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <TYPE> DataWriter<TYPE> lookupDataWriter(Topic<TYPE> topicName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BytesDataWriter lookupBytesDataWriter(Topic<byte[]> topicName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public KeyedBytesDataWriter lookupKeyedBytesDataWriter(
            Topic<KeyedBytes> topicName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public StringDataWriter lookupStringDataWriter(Topic<String> topicName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public KeyedStringDataWriter lookupKeyedStringDataWriter(
            Topic<KeyedString> topicName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void closeContainedEntities() {
        // TODO Auto-generated method stub

    }

    @Override
    public void suspendPublications() {
        // TODO Auto-generated method stub

    }

    @Override
    public void resumePublications() {
        // TODO Auto-generated method stub

    }

    @Override
    public void beginCoherentChanges() {
        // TODO Auto-generated method stub

    }

    @Override
    public void endCoherentChanges() {
        // TODO Auto-generated method stub

    }

    @Override
    public void waitForAcknowledgments(Duration maxWait)
            throws TimeoutException {
        // TODO Auto-generated method stub

    }

    @Override
    public void waitForAcknowledgments(long maxWait, TimeUnit unit)
            throws TimeoutException {
        // TODO Auto-generated method stub

    }

    @Override
    public DataWriterQos getDefaultDataWriterQos() {
        // TODO Auto-generated method stub
        DDS.DataWriterQosHolder holder = new DDS.DataWriterQosHolder();
        publisher.get_default_datawriter_qos(holder);
        return new OSPLDataWriterQos(holder.value);
    }

    @Override
    public void setDefaultDataWriterQos(DataWriterQos qos) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setDefaultDataWriterQos(String qosLibraryName,
            String qosProfileName) {
        // TODO Auto-generated method stub

    }

    @Override
    public void copyFromTopicQos(DataWriterQos dst, TopicQos src) {
        // TODO Auto-generated method stub

    }

    @Override
    public Collection<Class<? extends Status<?>>> getStatusChanges(
            Collection<Class<? extends Status<?>>> statuses) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BytesDataWriter createBytesDataWriter(Topic<byte[]> topic,
            DataWriterQos qos, DataWriterListener<byte[]> listener,
            Collection<Class<? extends Status<?>>> statuses) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public KeyedBytesDataWriter createKeyedBytesDataWriter(
            Topic<KeyedBytes> topic, DataWriterQos qos,
            DataWriterListener<KeyedBytes> listener,
            Collection<Class<? extends Status<?>>> statuses) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public StringDataWriter createStringDataWriter(Topic<String> topic,
            DataWriterQos qos, DataWriterListener<String> listener,
            Collection<Class<? extends Status<?>>> statuses) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public KeyedStringDataWriter createKeyedStringDataWriter(
            Topic<KeyedString> topic, DataWriterQos qos,
            DataWriterListener<KeyedString> listener,
            Collection<Class<? extends Status<?>>> statuses) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public KeyedStringDataWriter createKeyedStringDataWriter(
            Topic<KeyedString> topic, String qosLibraryName,
            String qosProfileName, DataWriterListener<KeyedString> listener,
            Collection<Class<? extends Status<?>>> statuses) {
        // TODO Auto-generated method stub
        return null;
    }

}
