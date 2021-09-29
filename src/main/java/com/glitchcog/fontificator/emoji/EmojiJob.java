package com.glitchcog.fontificator.emoji;

/**
 * A combination of type of emoji and operation to do on that type
 * 
 * @author Matt Yanos
 */
public class EmojiJob
{
    private final EmojiType type;

    private final EmojiOperation op;

    private final String oauth;

    /**
     * Can be null if no channel is required
     */
    private final String channel;

    public EmojiJob(String oauth, EmojiType type, EmojiOperation op)
    {
        this(oauth, type, op, null);
    }

    public EmojiJob(String oauth, EmojiType type, EmojiOperation op, String channel)
    {
        this.type = type;
        this.op = op;
        this.oauth = oauth;
        this.channel = channel;
    }

    public String getOauth()
    {
        return oauth;
    }

    public EmojiType getType()
    {
        return type;
    }

    public EmojiOperation getOp()
    {
        return op;
    }

    public String getChannel()
    {
        return channel;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((channel == null) ? 0 : channel.hashCode());
        result = prime * result + ((op == null) ? 0 : op.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EmojiJob other = (EmojiJob) obj;
        if (channel == null)
        {
            if (other.channel != null)
                return false;
        }
        else if (!channel.equals(other.channel))
            return false;
        if (op != other.op)
            return false;
        return type != other.type;

    }

    @Override
    public String toString()
    {
        return op.getDescription().substring(0, 1).toUpperCase() + op.getDescription().substring(1) + " " + type.getDescription() + (channel != null ? " for " + channel : "");
    }

}
